document.addEventListener("DOMContentLoaded", function() {

    let password1 = document.querySelector("#password1");
    let password2 = document.querySelector("#password2");
    let pass = "${password}";
    let passTest = "${passwordTest}";
    let alert = document.querySelector("#passwordAlert");

    function checkPassword() {
        if (pass !== passTest) {
            alert.innerHTML = "Podane hasła nie są identyczne";
            password2.appendChild(alert);
        }
        if (pass === passTest){
            password2.removeChild(alert);
        }
    }

    password1.addEventListener("keyup", () =>{
        if (passTest.length !== 0) checkPassword();
    })
    password2.addEventListener("keyup", checkPassword);

});