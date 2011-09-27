package com.googlecode.gwtphonegap.showcase.client.file;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.IsWidget;
import com.googlecode.gwtphonegap.client.PhoneGap;
import com.googlecode.gwtphonegap.client.file.DirectoryEntry;
import com.googlecode.gwtphonegap.client.file.DirectoryReader;
import com.googlecode.gwtphonegap.client.file.EntryBase;
import com.googlecode.gwtphonegap.client.file.FileCallback;
import com.googlecode.gwtphonegap.client.file.FileEntry;
import com.googlecode.gwtphonegap.client.file.FileError;
import com.googlecode.gwtphonegap.client.file.FileReader;
import com.googlecode.gwtphonegap.client.file.FileSystem;
import com.googlecode.gwtphonegap.client.file.FileWriter;
import com.googlecode.gwtphonegap.client.file.Flags;
import com.googlecode.gwtphonegap.client.file.ReaderCallback;
import com.googlecode.gwtphonegap.client.file.WriterCallback;
import com.googlecode.gwtphonegap.collection.shared.LightArray;


public class FilePresenter {

	private final FileDisplay display;
	private final PhoneGap phoneGap;

	public interface FileDisplay extends IsWidget {

		HasHTML getStatus();

		void clearEntries();

		void addEntry(String name, boolean b);

		public HasClickHandlers getEntry(int index);

		public HasClickHandlers goUpButton();

		public HasText getFileContent();

		public HasClickHandlers getFileUpdateButton();

		boolean confirm(String string);

		public HasClickHandlers getFileCreateButton();

		HasText getFileName();

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

		display.getFileUpdateButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (display.confirm("Really rewrite file?")) {
					if (currentFile != null) {
						currentFile.createWriter(new FileCallback<FileWriter, FileError>() {

							@Override
							public void onSuccess(FileWriter entry) {
								entry.setOnWriteEndCallback(new WriterCallback<FileWriter>() {

									@Override
									public void onCallback(FileWriter result) {
										Window.alert("file written");

									}
								});

								entry.setOnErrorCallback(new WriterCallback<FileWriter>() {

									@Override
									public void onCallback(FileWriter result) {
										Window.alert("error while writing file");

									}
								});
								entry.write(display.getFileContent().getText());

							}

							@Override
							public void onFailure(FileError error) {
								Window.alert("can not create writer");

							}
						});
					}
				}

			}
		});

		display.getFileCreateButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (currentDir != null) {
					String fileName = display.getFileName().getText();
					currentDir.getFile(fileName, new Flags(true, false), new FileCallback<FileEntry, FileError>() {

						@Override
						public void onSuccess(FileEntry entry) {
							listDirectory(currentDir);

						}

						@Override
						public void onFailure(FileError error) {
							Window.alert("error");

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
			event.preventDefault();

		}

	}

	private void readFile(int index) {
		FileEntry fileEntry = currentEntries.get(index).getAsFileEntry();
		readFile(fileEntry);
	}

	private void readFile(final FileEntry fileEntry) {
		FileReader reader = phoneGap.getFile().createReader();

		reader.setOnloadCallback(new ReaderCallback<FileReader>() {

			@Override
			public void onCallback(FileReader result) {

				// String result2 = result.getResult();
				//
				// String htmlEscape = SafeHtmlUtils.htmlEscape(result2);
				display.getFileContent().setText(result.getResult());
				currentFile = fileEntry;
			}
		});

		reader.setOnErrorCallback(new ReaderCallback<FileReader>() {

			@Override
			public void onCallback(FileReader result) {
				display.getFileContent().setText("Error while reading file");

			}
		});

		reader.readAsText(fileEntry);
	}

	private LightArray<EntryBase> currentEntries;

	private DirectoryEntry currentDir;

	private FileEntry currentFile;

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
