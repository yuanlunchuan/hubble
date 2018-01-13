$(function(){
	editAreaLoader.init({
		id: "resp-data"
		,start_highlight: true
		,allow_resize: "both"
		,allow_toggle: true
		,word_wrap: true
		,language: "zh"
		,syntax: "js"
		,allow_toggle: false
		,toolbar: "*,indent, format_but,compression_but,search, go_to_line, undo, redo, change_smooth_selection, reset_highlight, highlight, word_wrap, help, save, load, new_document, test_but, test_select"
		,font_size: 15
		,plugins: "format"
	});

	var Obj = {
			editAreaLoader: null,
			onFormatButtonClicked: function(event){
				var jsonText=editAreaLoader.getValue("resp-data");
				var json=JSON.stringify(JSON.parse(jsonText), null, 4);
				editAreaLoader.setValue("resp-data", json);
			},
			onGetValueClicked: function(event){
				alert(editAreaLoader.getValue("resp-data"));
			},
			onSetValueClicked: function(event){
				editAreaLoader.setValue("resp-data", "new_value");
			},
			init: function(){
				$("#format-button").on('click', Obj.onFormatButtonClicked);
				$("#get-value").on('click', Obj.onGetValueClicked);
				$("#set-value").on('click', Obj.onSetValueClicked);
			}
	};
	Obj.init();

	function my_load(id){
		editAreaLoader.setValue(id, "The content is loaded from the load_callback function into EditArea");
	}
	
	function test_setSelectionRange(id){
		editAreaLoader.setSelectionRange(id, 100, 150);
	}
	
	function test_getSelectionRange(id){
		var sel =editAreaLoader.getSelectionRange(id);
		alert("start: "+sel["start"]+"\nend: "+sel["end"]); 
	}
	
	function test_setSelectedText(id){
		text= "[REPLACED SELECTION]"; 
		editAreaLoader.setSelectedText(id, text);
	}
	
	function test_getSelectedText(id){
		alert(editAreaLoader.getSelectedText(id));
	}
	
	function editAreaLoaded(id){
		if(id=="example_2")
		{
			open_file1();
			open_file2();
		}
	}
	
	function open_file1()
	{
		var new_file= {id: "to\\ é # € to", text: "$authors= array();\n$news= array();", syntax: 'php', title: 'beautiful title'};
		editAreaLoader.openFile('example_2', new_file);
	}
	
	function open_file2()
	{
		var new_file= {id: "Filename", text: "<a href=\"toto\">\n\tbouh\n</a>\n<!-- it's a comment -->", syntax: 'html'};
		editAreaLoader.openFile('example_2', new_file);
	}
	
	function close_file1()
	{
		editAreaLoader.closeFile('example_2', "to\\ é # € to");
	}
	
	function toogle_editable(id)
	{
		editAreaLoader.execCommand(id, 'set_editable', !editAreaLoader.execCommand(id, 'is_editable'));
	}

    $("form").submit(function(e){
	    alert("Submitted");
	});
});
