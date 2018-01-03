$(function(){
	var Obj={
			onResponseDataClicked: function(){
				$('#myModal').modal({});
			},
			init: function(){
				$("#response-data").on('click', Obj.onResponseDataClicked);
			}
	}
	Obj.init();
});
