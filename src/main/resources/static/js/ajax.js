// $(document).ready(
//     function () {

//         // SUBMIT FORM
//         $("#bookForm").submit(function (event) {
//             // Prevent the form from submitting via the browser.
//             event.preventDefault();
//             ajaxPost();
//         });

function ajaxPost() {

    // PREPARE Rent DATA
    var rentData = {
        startRentDate: $(selectedDates[0]).val(),
        endRentDate: $(selectedDates.length > 1 ? selectedDates[1] : selectedDates[0]).val(),
        lot: $(lotId).val()
    }

    // DO POST
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/api/rent",
        data: JSON.stringify(rentData),
        dataType: 'json',
        success: function (result) {
            if (result.status == "success") {
                console.log("succes");
            } else {
                console.log("fail");
            }
            console.log(result);
        },
        error: function (e) {
            alert("Error!")
            console.log("ERROR: ", e);
        }
    });

}

// })