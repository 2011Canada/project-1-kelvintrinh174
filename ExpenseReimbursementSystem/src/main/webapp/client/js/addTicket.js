$(document).ready(function () {
  let inputAmount;
  let type = "1";
  let inputDescription = "";
  let inputReceipt;
  $("#inputAmount").change(function () {
    inputAmount = $("#inputAmount").val();
  });

  $("#inputDescription").change(function () {
    inputDescription = $("#inputDescription").val();
  });

  $("#selectType").change(function () {
    type = $("#selectType").val();
  });

  // $("#input-receipt").change(function () {
  //   const file = document.getElementById("input-receipt").files[0];
  //   const reader = new FileReader();

  //   reader.addEventListener(
  //     "load",
  //     function () {
  //       // convert image file to base64 string
  //       inputReceipt = reader.result;
  //     },
  //     false
  //   );

  //   if (file) {
  //     reader.readAsDataURL(file);
  //   }
  // });

  $("#ticket-form").submit(async function (e) {
    e.preventDefault();
    let ticket = {
      amount: parseFloat(inputAmount),
      authorId: parseInt(sessionStorage.getItem("userId")),
      statusId: 1,
      typeId: parseInt(type),
      dateSubmitted: "",
      description: inputDescription,
      //receipt: inputReceipt,
    };

    try {
      let res = await fetch(
        `http://localhost:8080/reimbursementsystem/addnewticket`,
        {
          method: "POST",
          body: JSON.stringify(ticket),
          headers: { "Content-Type": "application/json" },
        }
      );

      if (res.status === 201) {
        let data = await res.json();
        alert(`${data.msg}! Please click OK to come back`);
        window.location.assign("./employee.html");
      } else {
        let data = await res.text();
        alert(`${data}`);
      }
    } catch (err) {
      alert(err.message);
    }
  });
});
