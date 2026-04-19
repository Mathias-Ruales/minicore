document.addEventListener('DOMContentLoaded', function () {
    const form = document.getElementById('reporteForm');

    if (form) {
        form.addEventListener('submit', function (event) {
            const fechaInicio = document.getElementById('fechaInicio').value;
            const fechaFin = document.getElementById('fechaFin').value;

            if (fechaInicio && fechaFin) {
                if (fechaInicio > fechaFin) {
                    event.preventDefault();
                    alert('Error: La fecha de inicio no puede ser posterior a la fecha de fin.');
                }
            }
        });
    }
});
