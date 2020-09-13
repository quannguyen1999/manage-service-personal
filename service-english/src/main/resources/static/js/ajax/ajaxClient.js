toastr.options = {
		  "closeButton": true,
		  "debug": true,
		  "newestOnTop": true,
		  "progressBar": true,
		  "positionClass": "toast-bottom-right",
		  "preventDuplicates": false,
		  "showDuration": "300",
		  "hideDuration": "1000",
		  "timeOut": "5000",
		  "extendedTimeOut": "1000",
		  "showEasing": "swing",
		  "hideEasing": "linear",
		  "showMethod": "show",
		  "hideMethod": "hide"
		}
		function deleteDictionary(x){
			$("#enter").val("");
			$("#vietnameese").val("");
			$("#loaiType").val("");
			document.getElementById("description").innerHTML  = "";
			$.ajax({
				url : '/api/xoa/'+x,
				success : function(responseText) {
					var obj=JSON.stringify(responseText);
					var text=JSON.parse(obj);
					if(text['type']==false){
						toastr["error"](text['message']);
					}else{
						var nameTableid="#tableEnglish #"+x;
						$(nameTableid).remove();
						toastr["success"](text['message']);
					}
				}
			});
		}
