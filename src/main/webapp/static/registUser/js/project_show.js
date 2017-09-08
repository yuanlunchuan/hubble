$(function(){
	var Obj = {
			onMediaContainerHoveredIn: function(event){
				$(".remove-area").addClass("hidden");
				$(this).children(".media-right").removeClass("hidden");
			},
			onMediaContainerHoveredOut: function(event){
				$(".remove-area").addClass("hidden");
			},
			onMediaContainerClicked: function(event){
				alert("确定删除？");
			},
			initalize: function(){
    	  var self = Obj;
    	  $(".media").hover(self.onMediaContainerHoveredIn, self.onMediaContainerHoveredOut);
    	  $(".media").click(self.onMediaContainerClicked);
      }
	};
	Obj.initalize();
});
