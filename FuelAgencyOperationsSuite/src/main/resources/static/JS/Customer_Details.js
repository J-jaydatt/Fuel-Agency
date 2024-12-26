function deleteCustomer(consumerId) {
    if (confirm(`Are you sure you want to delete customer with ID ${consumerId}?`)) {
        fetch('/deleteCustomer/', {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            },
            body: new URLSearchParams({
                consumerId: `${consumerId}`, // Ensure consumerId is a string
            }),
        })
            .then(response => {
                if (response.ok) {
                    alert('Customer deleted successfully.');
                    location.reload(); // Reload the page to reflect changes
                } else {
                    alert('Failed to delete customer. Please try again.');
                }
            })
            .catch(error => {
                alert(`Error: ${error.message}`);
            });
    }
}
