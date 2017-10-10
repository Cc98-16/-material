$(function() {
	/** 全局链接抛出消息 **/
    $(document).on("click", "a", function(event) {
	   	event.preventDefault();
	   	var url = $(this).attr("href");
	   	$.get(url, function(json) {
	   		if(typeof(json) == "string") {
	   			window.location.href=url;
	   		} else if(typeof(json) == "object") {
	   			$.each(json, function(code, message) {
	   				var name = "[data-error='"+code+"']";
					 if ($(name).length > 0) {
                        $(name).html(message);
                    }
	            });
	   		}
	   	})
    })
    
	$(document).on("click", "[name='submit']", function(e){
		var form = $(this).parents('form');
		var url = $(form).attr("action");
		$("[data-error]").html("");		
		var options = {
			url: url,
			dataType:"json",
	        success: function (json) {
				var result = 1;
				if (typeof(json.tourl) == "undefined" || json.tourl == ""){
	        		$.each(json, function(code, message) {
	    				if (code != "tourl") {
	    					result = 2;
	    					var name = "[data-error='"+code+"']";
	    					 if ($(name).length > 0) {
		                         $(name).html(message);
		                     }
	    				}
	    			});
	        	}else if (result == 1 && json.tourl != ""){
					window.location.href = json.tourl;
				}
	       }
	     };
		$(form).ajaxForm(options);
	});
    
    $(document).ready(function(){
    	 var t = $("[name='cquantity']");
    	 $("[name='minus']").attr('disabled',true);
    	 $("[name='plus']").click(function(){ 
    		  $(this).prev("[name='cquantity']").val(Math.abs(parseInt(t.val()))+1);
    		  if (parseInt(t.val())!=1){
    			  $("[name='minus']").attr('disabled',false);
    		  };
    	});
    	 $("[name='minus']").click(function(){
    		 $(this).next("[name='cquantity']").val(Math.abs(parseInt(t.val()))-1);
    			 if (parseInt(t.val())==1){
    				 $("[name='minus']").attr('disabled',true);
    			 };
    		});
    });
    
    $("#chgAll").change(function(){
    	var flage =$(this).is(":checked");
    	$("input[type=checkbox]").each(function(){
    		 $(this).prop("checked",flage);
    	});
    });
    
	$(document).on("click","[data-load]",function(e){
		var url = $(this).data("load");
		$("#loadbox").load(url, function(){
			$(this).show("fast");
		});
	});
	
	$(document).on("click","[data-refuseload]",function(e){
		var url = $(this).data("refuseload");
		$("#refuseloadbox").load(url, function(){
			$(this).show("fast");
		});
	});
	
	$(document).on("click","[data-returnload]",function(e){
		var url = $(this).data("returnload");
		$("#returnloadbox").load(url, function(){
			$(this).show("fast");
		});
	});
	
	$(document).on("click","[data-pmaterialload]",function(e){
		var url = $(this).data("pmaterialload");
		$("#pmaterialload").load(url, function(){
			$(this).show("fast");
		});
	});
	
	$(document).on("click","[data-id]",function(e){
		e.preventDefault();
		var id = $(this).data("id");
		var status = "invalid";
		if(!window.confirm("确认要下架吗")){return false;}
		$.post("/delete", {"id":id,"status":status}, function(json) {
			if(json.result == "success")
				location.reload(true);
		})
	});
	
	$(document).on("click","[data-applyid]",function(e){
		e.preventDefault();
		var id = $(this).data("applyid");
		if(!window.confirm("确认申请人已拿到材料")){return false;}
		$.post("/accesssava", {"id":id}, function(json) {
			if(json.result == "success")
				location.reload(true);
		})
	});
	
	$(document).on("click","[data-shelvesid]",function(e){
		e.preventDefault();
		var shelvesid=$(this).data("shelvesid");
		var status = "stock"
		$.post("/shelves",{"shelvesid":shelvesid, "status":status },function(json){
			if(json.result == "success")
				location.reload(true);
		});
	});
	
	$(document).on("click","[data-listid]",function(e){
		e.preventDefault();
		var listid = $(this).data("listid");
		var lquantity = $(this).parent().prev().children("#cquantity").val();
		var type = "out"
		$.post("/list",{"listid":listid,"type":type,"lquantity":lquantity},function(json){
			if(json.result == "success")
				location.reload(true);
		});
	});
	
	$(document).on("click","[name='load_close']",function(){
        $("#loadbox").slideUp();
    });
	
	$(document).on("click","[name='load_closereturn']",function(){
        $("#returnloadbox").slideUp();
    });
	
	$(document).on("click","[name='load_refuseclose']",function(){
        $("#refuseloadbox").slideUp();
    });
    
    $("#asinstructions").click(function (e) {
        $(".hide").toggleClass("none");
    });
    
    $("#quotes").click(function (e) {
        $(".hide2").toggleClass("none");
    });
    $("#contract").click(function (e) {
        $(".hide3").toggleClass("none");
    });
    $("#deliverbill").click(function (e) {
        $(".hide4").toggleClass("none");
    });
    $("#invoice").click(function (e) {
        $(".hide5").toggleClass("none");
    });
    $("#receipt").click(function (e) {
        $(".hide6").toggleClass("none");
    });
    $("#warehousing").click(function (e) {
        $(".hide7").toggleClass("none");
    });
    $("#reimbursement").click(function (e) {
        $(".hide8").toggleClass("none");
    });
    
    $("#mask").click(function (e) {
        $(".hide").removeClass("none");
    });
    $("#mask2").click(function (e) {
        $(".hide2").removeClass("none");
    });
    $("#mask3").click(function (e) {
        $(".hide3").removeClass("none");
    });
    $("#mask4").click(function (e) {
        $(".hide4").removeClass("none");
    });
    $("#mask5").click(function (e) {
        $(".hide5").removeClass("none");
    });
    $("#mask6").click(function (e) {
        $(".hide6").removeClass("none");
    });
    $("#mask7").click(function (e) {
        $(".hide7").removeClass("none");
    });
    $("#mask8").click(function (e) {
        $(".hide8").removeClass("none");
    });


	    $(document).on("click", ".in_drowndrop", function() {
	    		// console.log(11);
	        $(".more_list").toggle("");
	    });

    // $(function(){
    //     $(".in_drowndrop").toggle(
    //         function(){
    //             $(this).text("收起选项-");
    //             $(".more_list").show();
    //         },
    //         function(){
    //             $(this).text("展开选项+");
    //             $(".more_list").hide();
    //         }
    //     )
    // })
	  
     
});