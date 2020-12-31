const baseURL = "http://localhost:8080/reimbursementsystem/";

$(document).ready(async () => {
  let data = await getAllTicketEmployee();
  console.log(data);
  updateTicketTable(data);
});

async function getAllTicketEmployee() {
  let userId = sessionStorage.getItem("userId");
  try {
    let response = await fetch(
      `${baseURL}getallticketemployee?userId=${userId}`
    );
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
  data.forEach((e, i) => {
    let newRow = `<tr>
    <th scope="row">${i + 1}</th>
    <td>${e.amount}$</td>
    <td>${e.reimbStatus}</td>
    <td>${e.description}</td>
    <td>${e.reimbType}</td>
    <td>${e.dateSubmitted}</td>
    <td>${e.dateResolved || "Not Available"}</td>
    </tr>`;
    $("#table-body").append(newRow);
  });

  //console.log(card);
}
