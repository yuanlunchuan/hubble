$(function(){
//Set default options
	JSONEditor.defaults.options.theme = 'bootstrap3';

	// Initialize the editor
	var editor = new JSONEditor(document.getElementById("editor_holder"),{
	  schema: {
	  	  "title": "response",  
	  	  type: "object",
	      properties: {
	      }
	  },
	  iconlib: "fontawesome4"
	});

	// Set the value
/*	editor.setValue({
	    name: "John Smith"
	});*/

	// Get the value
	var data = editor.getValue();
	console.log(data.name); // "John Smith"

	// Validate
	var errors = editor.validate();
	if(errors.length) {
	  // Not valid
	}

	// Listen for changes
	editor.on("change",  function(event) {
	  // Do something...
		$("#jsonText").val(JSON.stringify(editor.getValue(),null, 4));
		//console.info("----"+ JSON.Stringify(editor.getValue()));
	});
});