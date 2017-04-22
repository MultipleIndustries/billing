/**
 * 
 */
$(function() {
$('.feature-control').change(function() {
			if(this.checked){
				$("#message_link" ).trigger( "click" );
				if(this.id == "offer"){
					$("#messageInfo").html("1. The offer will be over and above the exclusive offer already given to the Gourmet7 members <br>2. The details of this offer will be solely decided by you <br>3. The terms and duration of availing this offer must be very clearly mentioned along with the offer");
				}
				if(this.id == "promocode"){
					$("#messageInfo").html("1. The special benefits given through promo code will be over and above the exclusive offer already given to the Gourmet7 members<br>2. The number of promo codes to be offered and the actual offer will be decided solely by you<br>3. Kindly ensure that all your outlets where promo codes will be accepted are made aware of the same  <br>4. The terms and duration of availing offer through promo codes must be very clearly mentioned along with the offer<br>5. The promo code offer once rolled out, cannot be discontinued mid-way");
				}
				if(this.id == "giftameal"){
					$("#messageInfo").html("By selecting this feature you are allowing the user to use the selected service.");
				}
				if(this.id == "evite"){
					$("#messageInfo").html("By selecting this feature you are allowing the user to use the selected service.");
				}
				if(this.id == "preordermeal"){
					$("#messageInfo").html("By selecting this feature you are allowing the user to use the selected service.");
				}
				if(this.id == "mpay"){
					$("#messageInfo").html("By selecting this feature you are allowing the user to use the selected service.");
				}
				if(this.id == "waittimetracker"){
					$("#messageInfo").html("By selecting this feature you are allowing the user to use the selected service.");
				}
				if(this.id == "splitbill"){
					$("#messageInfo").html("By selecting this feature you are allowing the user to use the selected service.");
				}
				if(this.id == "tableregistration"){
					$("#messageInfo").html("By selecting this feature you are allowing the user to use the selected service.");
				}
				if(this.id == "callforservice"){
					$("#messageInfo").html("1. To avail the Call for services feature, kindly ensure that you have a high speed internet connection installed and available at your location<br>2. The call for services features will only work on Android based tablets and no other platforms<br>3. At any point, if you do not wish to offer these services to your guests, kindly disable the same from your administrative login<br>4. Kindly inform your staff present at the outlet about the changes<br>5. To avoid misuse of the features, once a guest calls for a particular service, the same feature will only be available again after a short interval<br>6. Gourmet7 will not be held responsible for delays in receiving any such notifications.");
				}
			}
			else{
				$("#current_feature").val(this.id);
				$("#warning_message_link" ).trigger( "click" );
			}
});

$("#no_deselect").click(function(){
	var currentFetaure = $("#current_feature").val();
	$("#"+currentFetaure).prop( "checked", true );
});
});
