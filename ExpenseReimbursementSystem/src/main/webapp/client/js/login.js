async function loginSubmit(e) {
  e.preventDefault();
  let username = document.getElementById("username-input").value;
  let password = document.getElementById("password-input").value;

  // enhanced object literrals
  const credentials = {
    username,
    password,
  };
  try {
    let res = await fetch(`http://localhost:8080/reimbursementsystem/login`, {
      method: "POST",
      body: JSON.stringify(credentials),
      headers: { "Content-Type": "application/json" },
    });

    console.log(res.body);
    if (res.status == 200) {
      let user = await res.json();
      let {
        userId,
        userName,
        firstName,
        lastName,
        email,
        userRoleId,
        userRole,
      } = user;

      sessionStorage.setItem("userId", userId);
      sessionStorage.setItem("userName", userName);
      sessionStorage.setItem("firstName", firstName);
      sessionStorage.setItem("lastName", lastName);
      sessionStorage.setItem("email", email);
      sessionStorage.setItem("userRoleId", userRoleId);
      sessionStorage.setItem("userRole", userRole);

      if (userRole === "EMPLOYEE") {
        window.location.assign("./employee.html");
      } else if (userRole === "MANAGER") {
        window.location.assign("./manager.html");
      }
    } else {
      let msg = await res.text();
      alert(msg);
    }
  } catch (err) {
    console.log(err);
  }
}

document
  .getElementsByTagName("form")[0]
  .addEventListener("submit", loginSubmit);
