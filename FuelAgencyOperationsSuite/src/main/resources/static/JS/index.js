// menu_page.js
window.onload = function() {
    var successMessage = document.getElementById("successMessage");
    if (successMessage) {
        setTimeout(function() {
            successMessage.style.display = 'none';
        }, 3000); // Hide the message after 1 seconds
    }
};
