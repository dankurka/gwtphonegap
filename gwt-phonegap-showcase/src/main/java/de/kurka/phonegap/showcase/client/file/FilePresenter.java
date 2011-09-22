package de.kurka.phonegap.showcase.client.file;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.IsWidget;

import de.kurka.gwt.collection.shared.LightArray;
import de.kurka.phonegap.client.PhoneGap;
import de.kurka.phonegap.client.file.DirectoryEntry;
import de.kurka.phonegap.client.file.DirectoryReader;
import de.kurka.phonegap.client.file.EntryBase;
import de.kurka.phonegap.client.file.FileCallback;
import de.kurka.phonegap.client.file.FileEntry;
import de.kurka.phonegap.client.file.FileError;
import de.kurka.phonegap.client.file.FileReader;
import de.kurka.phonegap.client.file.FileSystem;
import de.kurka.phonegap.client.file.ReaderCallback;

public class FilePresenter {

	private final FileDisplay display;
	private final PhoneGap phoneGap;

	public interface FileDisplay extends IsWidget {

		HasHTML getStatus();

		void clearEntries();

		void addEntry(String name, boolean b);

		public HasClickHandlers getEntry(int index);

		public HasClickHandlers goUpButton();

		public HasHTML getFileContent();

	}

	public FilePresenter(FileDisplay display, PhoneGap phoneGap) {
		this.display = display;
		this.phoneGap = phoneGap;

		bind();

	}

	protected void bind() {

		display.getStatus().setHTML("Requesting File System");

		phoneGap.getFile().requestFileSystem(FileSystem.LocalFileSystem_PERSISTENT, 0, new FileCallback<FileSystem, FileError>() {

			@Override
			public void onSuccess(FileSystem entry) {
				gotFileSyste(entry);

			}

			@Override
			public void onFailure(FileError error) {
				display.getStatus().setHTML("Failed to request file system with error code: " + error.getErrorCode());

			}
		});

		display.goUpButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (currentDir != null) {
					currentDir.getParent(new FileCallback<DirectoryEntry, FileError>() {

						@Override
						public void onSuccess(DirectoryEntry entry) {
							listDirectory(entry);

						}

						@Override
						public void onFailure(FileError error) {
							Window.alert("error und so !!!!!!!!");

						}
					});
				}
			}
		});
	}

	private void gotFileSyste(FileSystem fileSystem) {
		listDirectory(fileSystem.getRoot());
	}

	private class DirectoryClickHandler implements ClickHandler {

		private final int index;

		public DirectoryClickHandler(int index) {
			this.index = index;

		}

		@Override
		public void onClick(ClickEvent event) {
			listDirectory(index);
			event.preventDefault();

		}

	}

	private class FileClickHandler implements ClickHandler {

		private final int index;

		public FileClickHandler(int index) {
			this.index = index;

		}

		@Override
		public void onClick(ClickEvent event) {
			readFile(index);

		}

	}

	private void readFile(int index) {
		FileEntry fileEntry = currentEntries.get(index).getAsFileEntry();
		readFile(fileEntry);
	}

	private void readFile(FileEntry fileEntry) {
		FileReader reader = phoneGap.getFile().createReader();

		reader.setOnloadCallback(new ReaderCallback<FileReader>() {

			@Override
			public void onCallback(FileReader result) {

				String result2 = result.getResult();

				String htmlEscape = SafeHtmlUtils.htmlEscape(result2);
				display.getFileContent().setHTML("Content: '<textarea style='width: 300px; height: 300px;'>" + htmlEscape + "</textarea>");

			}
		});

		reader.setOnErrorCallback(new ReaderCallback<FileReader>() {

			@Override
			public void onCallback(FileReader result) {
				display.getFileContent().setHTML("Error while reading file");

			}
		});

		reader.readAsText(fileEntry);
	}

	private LightArray<EntryBase> currentEntries;

	private DirectoryEntry currentDir;

	private void listDirectory(int index) {
		listDirectory(currentEntries.get(index).getAsDirectoryEntry());
	}

	private void listDirectory(final DirectoryEntry directoryEntry) {
		currentDir = directoryEntry;

		display.clearEntries();
		display.getStatus().setHTML("Listing '" + directoryEntry.getName() + "");
		DirectoryReader directoryReader = directoryEntry.createReader();

		directoryReader.readEntries(new FileCallback<LightArray<EntryBase>, FileError>() {

			@Override
			public void onSuccess(LightArray<EntryBase> entries) {
				currentEntries = entries;
				display.getStatus().setHTML("Directory '" + directoryEntry.getFullPath() + "'");

				for (int i = 0; i < entries.length(); i++) {
					EntryBase entryBase = entries.get(i);

					if (entryBase.isDirectory()) {
						DirectoryEntry directoryEntry = entryBase.getAsDirectoryEntry();
						String name = directoryEntry.getName();
						display.addEntry(name, true);
						display.getEntry(i).addClickHandler(new DirectoryClickHandler(i));
					} else {
						FileEntry fileEntry = entryBase.getAsFileEntry();
						String name = fileEntry.getName();
						display.addEntry(name, false);
						display.getEntry(i).addClickHandler(new FileClickHandler(i));
					}

				}

			}

			@Override
			public void onFailure(FileError error) {
				display.getStatus().setHTML("Error while listing '" + directoryEntry.getFullPath() + "'");

			}
		});
	}

	public IsWidget getDisplay() {
		return display;
	}
}
