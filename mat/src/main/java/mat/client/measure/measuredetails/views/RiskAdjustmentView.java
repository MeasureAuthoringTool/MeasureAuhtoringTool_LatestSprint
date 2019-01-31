package mat.client.measure.measuredetails.views;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

import mat.client.measure.measuredetails.observers.MeasureDetailsComponentObserver;
import mat.client.measure.measuredetails.observers.RiskAdjustmentObserver;
import mat.client.shared.ConfirmationDialogBox;
import mat.client.shared.editor.RichTextEditor;
import mat.shared.measure.measuredetails.models.MeasureDetailsComponentModel;
import mat.shared.measure.measuredetails.models.RiskAdjustmentModel;

public class RiskAdjustmentView implements MeasureDetailViewInterface {
	private FlowPanel mainPanel = new FlowPanel();
	
	private MeasureDetailsRichTextEditor measureDetailsRichTextEditor;
	private RiskAdjustmentModel model;
	private RiskAdjustmentModel originalModel;
	private RiskAdjustmentObserver observer;
	
	public RiskAdjustmentView() {
		
	}
	
	public RiskAdjustmentView(RiskAdjustmentModel model) {
		this.originalModel = model; 
		buildModel(this.originalModel);
		buildDetailView();
	}
	
	@Override
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
		measureDetailsRichTextEditor.getRichTextEditor().setTitle("Risk Adjustment Editor");
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
	public RichTextEditor getRichTextEditor() {
		return this.measureDetailsRichTextEditor.getRichTextEditor();
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMeasureDetailsComponentModel(MeasureDetailsComponentModel model) {
		this.model = (RiskAdjustmentModel) model; 	
		this.originalModel = this.model;
		buildModel(this.originalModel);	
	}

	@Override
	public void setObserver(MeasureDetailsComponentObserver observer) {
		this.observer = (RiskAdjustmentObserver) observer; 
	}
	
	@Override
	public MeasureDetailsComponentObserver getObserver() {
		return observer;
	}
	
	private void buildModel(RiskAdjustmentModel model) {
		this.model = new RiskAdjustmentModel(model);
	}
	
	private void addEventHandlers() {
		measureDetailsRichTextEditor.getRichTextEditor().addKeyUpHandler(event -> observer.handleValueChanged());		
	}
}
