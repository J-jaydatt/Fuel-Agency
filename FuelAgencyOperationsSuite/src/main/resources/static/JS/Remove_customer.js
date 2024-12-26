window.onload = function () {
    const messageDiv = document.getElementById('message');
    if (messageDiv) {
        setTimeout(function () {
            messageDiv.style.display = 'none';
        }, 2000); // Hide after 2 seconds
    }
};



// Add interactivity with form validation
document.getElementById('deleteForm').addEventListener('submit', function(event) {
	const consumerId = document.getElementById('consumerId').value;

	// Ensure the consumer ID is 17 digits long
	if (!/^\d{17}$/.test(consumerId)) {
		alert("Please enter a valid 17-digit Consumer ID.");
		event.preventDefault();
	}
});
