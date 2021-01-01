const baseURL = "http://localhost:8080/reimbursementsystem/";
let listTicket;
$(document).ready(async () => {
  let data = await getAllTicket();
  listTicket = data;
  let listTicketId = updateTicketTable(data);

  //add event listener for each view button in the first load
  listTicketId.forEach((id) => {
    $(`#ticket-${id}`).click(function (e) {
      e.preventDefault();
      sessionStorage.setItem("ticketId", id);
      window.location.assign("./viewTicket.html");
    });
  });

  $("#search-pending").click(function (e) {
    e.preventDefault();
    let pendingTicketList = listTicket.filter(function (e) {
      return e.reimbStatus === "PENDING";
    });
    //console.log(pendingTicketList);
    let listPendingTicketId = searchTicketTable(pendingTicketList);
    listPendingTicketId.forEach((id) => {
      $(`#ticket-${id}`).click(function (e) {
        e.preventDefault();
        sessionStorage.setItem("ticketId", id);
        window.location.assign("./viewTicket.html");
      });
    });
  });
});

function searchTicketTable(data) {
  $("#table-body").remove();
  let newRows;
  let listTicketId = [];
  data.forEach((e, i) => {
    newRows += `
        <tr>
        <th scope="row">${i + 1}</th>
        <td>${e.amount}$</td>
        <td>${e.reimbStatus}</td>
        <td>${e.description}</td>
        <td>${e.reimbType}</td>
        <td>${e.dateSubmitted}</td>
        <td>${e.dateResolved || "Not Available"}</td>
        <td>${e.authorName}</td>
        <td>${e.authorEmail}</td>
        <td><button class="btn btn-outline-info" id="ticket-${
          e.reimbId
        }">View</button></td>
        </tr>
        `;
    listTicketId.push(e.reimbId);
  });

  $("#table-ticket").append(`<tbody id="table-body">${newRows}</tbody>`);
  return listTicketId;
}

async function getAllTicket() {
  try {
    let response = await fetch(`${baseURL}getallticket`);
    let data = await response.json();

    return data;
  } catch (e) {
    alert(e.message);
  }
}

function updateTicketTable(data) {
  let name =
    sessionStorage.getItem("firstName") +
    " " +
    sessionStorage.getItem("lastName");
  //update username
  $("#username").text(`${name}`);
  let listTicketId = [];
  data.forEach((e, i) => {
    let newRow = `<tr>
    <th scope="row">${i + 1}</th>
    <td>${e.amount}$</td>
    <td>${e.reimbStatus}</td>
    <td>${e.description}</td>
    <td>${e.reimbType}</td>
    <td>${e.dateSubmitted}</td>
    <td>${e.dateResolved || "Not Available"}</td>
    <td>${e.authorName}</td>
    <td>${e.authorEmail}</td>
    <td><button class="btn btn-outline-info" id="ticket-${
      e.reimbId
    }">View</button></td>
    </tr>`;
    listTicketId.push(e.reimbId);
    $("#table-body").append(newRow);
  });
  return listTicketId;
  //console.log(card);
}
