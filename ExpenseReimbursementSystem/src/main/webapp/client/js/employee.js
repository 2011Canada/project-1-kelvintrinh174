const baseURL = "http://localhost:8080/reimbursementsystem/";

$(document).ready(async () => {
  let userId = sessionStorage.getItem("userId");
  if (userId != null) {
    let data = await getAllTicketEmployee(userId);
    updateTicketTable(data);
  } else {
    alert("Please log in!");
  }

  $("#log-out").click(function (e) {
    e.preventDefault();
    //alert("Logged out");
    //document.cookie("JSESSIONID=0;max-age=0");
    window.location.assign("./index.html");
  });
});

async function getAllTicketEmployee(userId) {
  try {
    let response = await fetch(
      `${baseURL}getallticketemployee?userId=${userId}`,
      {
        method: "GET",
        //credentials: "same-origin",
      }
    );
    if (response.status === 200) {
      let data = await response.json();

      return data;
    } else {
      let msg = await response.text();
      alert(msg);
    }
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
  if (data) {
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
  }

  //console.log(card);
}
