package mat.client.measure.measuredetails.views;

import org.gwtbootstrap3.client.ui.gwt.FlowPanel;

import com.google.gwt.user.client.ui.Widget;

import mat.client.measure.measuredetails.observers.DenominatorExceptionsObserver;
import mat.client.measure.measuredetails.observers.MeasureDetailsComponentObserver;
import mat.client.shared.ConfirmationDialogBox;
import mat.client.shared.editor.RichTextEditor;
import mat.shared.measure.measuredetails.models.DenominatorExceptionsModel;
import mat.shared.measure.measuredetails.models.MeasureDetailsComponentModel;

public class DenominatorExceptionsView implements MeasureDetailViewInterface {
	private FlowPanel mainPanel = new FlowPanel();
	private MeasureDetailsRichTextEditor measureDetailsRichTextEditor;
	private DenominatorExceptionsModel model;
	private DenominatorExceptionsModel originalModel;
	private DenominatorExceptionsObserver observer;
	
	public DenominatorExceptionsView() {

	}
	
	public DenominatorExceptionsView(DenominatorExceptionsModel model) {
		this.originalModel = model; 
		buildModel(this.originalModel);
		buildDetailView();
	}

	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return true;
	}

	public Widget getWidget() {
		return mainPanel;
	}

	@Override
	public boolean hasUnsavedChanges() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void buildDetailView() {
		measureDetailsRichTextEditor = new MeasureDetailsRichTextEditor(mainPanel);
		measureDetailsRichTextEditor.getRichTextEditor().setTitle("Denominator Exceptions Editor");
		measureDetailsRichTextEditor.getRichTextEditor().setEditorText(this.model.getFormattedText());	
		addEventHandlers();		
	}

	@Override
	public void setReadOnly(boolean readOnly) {
		this.measureDetailsRichTextEditor.setReadOnly(readOnly);
	}
	
	@Override
	public ConfirmationDialogBox getSaveConfirmation() {
		return null;
	}

	@Override
	public void resetForm() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MeasureDetailsComponentModel getMeasureDetailsComponentModel() {
		return this.model;
	}
	
	@Override
	public void setMeasureDetailsComponentModel(MeasureDetailsComponentModel model) {
		this.model = (DenominatorExceptionsModel) model; 	
		this.originalModel = this.model;
		buildModel(this.originalModel);		
	}

	@Override
	public RichTextEditor getRichTextEditor() {
		return this.measureDetailsRichTextEditor.getRichTextEditor();
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void setObserver(MeasureDetailsComponentObserver observer) {
		this.observer = (DenominatorExceptionsObserver) observer; 		
	}
	
	@Override
	public MeasureDetailsComponentObserver getObserver() {
		return observer;
	}

	private void buildModel(DenominatorExceptionsModel model) {
		this.model = new DenominatorExceptionsModel(model);
	}
	
	private void addEventHandlers() {
		measureDetailsRichTextEditor.getRichTextEditor().addKeyUpHandler(event -> observer.handleValueChanged());		
	}
}