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
    let user = await res.json();
    alert(JSON.stringify(user));
  } catch (err) {
    console.log(err);
  }

}

document
  .getElementsByTagName("form")[0]
  .addEventListener("submit", loginSubmit);
