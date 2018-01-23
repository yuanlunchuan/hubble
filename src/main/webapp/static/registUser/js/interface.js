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
		,toolbar: "*,indent, format_but,compression_but,search, go_to_line, undo, redo, change_smooth_selection, reset_highlight, highlight"
		,font_size: 15
		,plugins: "format"
		,browsers: "all"
	});

	var Obj = {
			init: function(){
			}
	};
	Obj.init();

    $("form").submit(function(e){
	    //alert("Submitted");
	});
});
