let inputAmount;
let type = "1";
let inputDescription = "";
$("#inputAmount").change(function () {
  inputAmount = $("#inputAmount").val();
});

$("#inputDescription").change(function () {
  inputDescription = $("#inputDescription").val();
});

$("#selectType").change(function () {
  type = $("#selectType").val();
});

$("#ticket-form").submit(async function (e) {
  e.preventDefault();
  let ticket = {
    amount: parseFloat(inputAmount),
    authorId: parseInt(sessionStorage.getItem("userId")),
    statusId: 1,
    typeId: parseInt(type),
    dateSubmitted: "",
    description: inputDescription,
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
