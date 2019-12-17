<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>


<script type="text/javascript">

$(document)
			.ready(
					function() {

						$("#success_alert").hide();
						$("#error_alert").hide();

						jQuery.validator.addMethod("isIssueRenewalIdUnique", function(value, element){
							var status= false;							
						    $.get({
								async : false,
						    	url : 'isIssueRenewalIdUnique',
								data : {continentName : value},
								success : function(res) {
									alert("RESPONSE :"+res);
									if(res){
										console.log("Status :"+res)
										status = true;
									}								
								},
								error : function(res) {
									//alert("res e:"+res);									
								}
							});						    
						    return status;
						}, "IssueRenewalId with the same name already exists."); 
						
						
						$("#issueRenewal")
								.submit(function(e) {
									e.preventDefault();
								})
								.validate(
										{
											rules : {
												continentId : {
													required : true,
													maxlength : 2,
													remote : 'isIssueRenewalIdUnique'
													
												}
											},
											highlight : function(element,
													errorClass, validClass) {
												$(element)
														.addClass(
																"border-danger text-danger")
														.removeClass(validClass);
											},
											unhighlight : function(element,
													errorClass, validClass) {
												$(element)
														.addClass(validClass)
														.removeClass(
																"border-danger text-danger");
											},
											submitHandler : function(form) {
												addContinentDetails();
												return false; //This doesn't prevent the form from submitting.
											}
										});
					});

	
	// Function to add language details 
	function addContinentDetails() {

		$.post({
			url : 'addIssueRenewalDetails',
			data : $('form[name=issueRenewal]').serialize(),
			success : function(res) {
				$("#success_alert").fadeTo(2000, 500).slideUp(500, function() {
					$("#success_alert").slideUp(500);
					$("form[name=issueRenewal]").trigger("reset");
				});
			},
			error : function(res) {
				$("#error_alert").fadeTo(2000, 500).slideUp(500, function() {
					$("#error_alert").slideUp(500);
				});
			}
		});
	}


</script>


</html>