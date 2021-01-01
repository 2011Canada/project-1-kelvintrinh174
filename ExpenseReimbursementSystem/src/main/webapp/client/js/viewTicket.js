$(document).ready(async () => {
  let detail = await getTicketById();
  updateForm(detail);
  $("#update-ticket").click(function (e) {
    e.preventDefault();
    let resolverId = sessionStorage.getItem("userId");
    let dateResolved = "";
    let reimbId = $("#inputRequestId").val();
    let statusId = $("#inputState").val();
    updateRequest({ resolverId, dateResolved, reimbId, statusId });
  });
});

async function getTicketById() {
  try {
    let id = sessionStorage.getItem("ticketId");
    let res = await fetch(
      `http://localhost:8080/reimbursementsystem/getticketbyid?ticketId=${id}`
    );

    if (res.status === 200) {
      let ticketDetail = await res.json();
      return ticketDetail;
    } else {
      let error = await res.text();

      alert(error);
    }
  } catch (err) {
    alert(err.message);
  }
}

function updateForm(ticketDetail) {
  let name =
    sessionStorage.getItem("firstName") +
    " " +
    sessionStorage.getItem("lastName");
  //update username
  $("#username").text(`${name}`);

  //update form fields
  if (ticketDetail) {
    $("#inputDescription").val(ticketDetail.description);
    $("#inputRequestId").val(ticketDetail.reimbId);
    $("#inputEmail").val(ticketDetail.authorEmail);
    $("#inputEmployee").val(ticketDetail.authorName);
    $("#inputType").val(ticketDetail.reimbType);
    $("#inputState").val(ticketDetail.statusId);
    $("#inputAmount").val(ticketDetail.amount);
  }
}

async function updateRequest(ticketDetail) {
  try {
    let res = await fetch(
      `http://localhost:8080/reimbursementsystem/updaterequest`,
      {
        method: "PUT",
        body: JSON.stringify(ticketDetail),
        headers: { "Content-Type": "application/json" },
      }
    );

    if (res.status === 200) {
      let { msg } = await res.json();
      alert(`${msg}! Please click OK to come back`);
      window.location.assign("./manager.html");
    } else {
      let msg = await res.text();
      alert(msg);
    }
  } catch (err) {
    alert(err.message);
  }
}
