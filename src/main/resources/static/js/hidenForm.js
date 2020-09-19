document.addEventListener("DOMContentLoaded", function() {

    let sugarDetails = document.querySelector("#sugarDetails");
    let checkbox = document.querySelector("#details");

    sugarDetails.classList.add("d-none");

    checkbox.addEventListener("click", function () {
        if(checkbox.checked){
            sugarDetails.style.display = "block";
        } else {
            sugarDetails.style.display = "none";
        }
    })
});