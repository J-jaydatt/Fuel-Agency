document.getElementById('editForm').addEventListener('submit', function(event) {
    event.preventDefault();  // Prevent form from submitting normally
    const custId = document.querySelector('input[name="cust_id"]').value;

    // Redirect to Edit_Details.html with cust_id as a request parameter
    window.location.href = `/edit?cust_id=${custId}`;
});


/*<script>
        function activateCustomer() {
            if (confirm("Are you sure you want to activate this customer?")) {
                fetch('/activate/' + document.getElementById('consumerId').value, { method: 'POST' })
                    .then(response => {
                        if (response.ok) {
                            window.location.reload();
                        }
                    });
            }
        }
    </script>-->*/