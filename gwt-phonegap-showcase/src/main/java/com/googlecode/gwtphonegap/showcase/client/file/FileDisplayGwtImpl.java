package com.googlecode.gwtphonegap.showcase.client.file;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwtphonegap.showcase.client.file.FilePresenter.FileDisplay;


public class FileDisplayGwtImpl implements FileDisplay {

	private DisclosurePanel main;
	private FlowPanel content;
	private HTML status;
	private FlowPanel listing;
	private Button goUpButton;
	private TextArea fileContent;
	private Button fileChangeButton;
	private Button createFileButton;

	public FileDisplayGwtImpl() {
		main = new DisclosurePanel("File");

		content = new FlowPanel();

		status = new HTML();
		content.add(status);

		goUpButton = new Button("go up");
		content.add(goUpButton);

		main.add(content);

		listing = new FlowPanel();
		content.add(listing);

		content.add(new HTML("File Content"));

		fileContent = new TextArea();
		content.add(fileContent);
		fileChangeButton = new Button("overwrite file!");
		content.add(fileChangeButton);

		createFileButton = new Button("createFile");
		content.add(createFileButton);

	}

	@Override
	public Widget asWidget() {
		return main;
	}

	@Override
	public HasHTML getStatus() {
		return status;
	}

	@Override
	public void clearEntries() {
		listing.clear();
		entries.clear();
	}

	private ArrayList<HTML> entries = new ArrayList<HTML>();

	@Override
	public void addEntry(String name, boolean isDir) {
		HTML entry = new HTML();

		entry.setHTML("<a href=''>" + name + "</a>");

		entries.add(entry);
		listing.add(entry);

	}

	@Override
	public HasClickHandlers getEntry(int index) {
		return entries.get(index);
	}

	@Override
	public HasClickHandlers goUpButton() {
		return goUpButton;
	}

	@Override
	public HasText getFileContent() {
		return fileContent;
	}

	@Override
	public HasClickHandlers getFileUpdateButton() {
		return fileChangeButton;
	}

	@Override
	public boolean confirm(String string) {
		return Window.confirm(string);
	}

	@Override
	public HasClickHandlers getFileCreateButton() {
		return createFileButton;
	}

	@Override
	public HasText getFileName() {
		return new HasText() {

			@Override
			public void setText(String text) {

			}

			@Override
			public String getText() {
				return Window.prompt("Filename", "");
			}
		};

	}

}
