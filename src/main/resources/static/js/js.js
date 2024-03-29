const addPosition = document.getElementById("addPosition");
if (addPosition) {
    addPosition.onclick = () => {
        let positionIndex = document.getElementById("positions").children.length;
        const positionDiv = document.createElement("div");
        positionDiv.innerHTML = '<label>Позиция ' + (positionIndex + 1) + ':</label>' +
            '<input type="text" name="positions[' + positionIndex + '].name">' +
            '<input type="text" name="positions[' + positionIndex + '].number">' +
            '<input type="text" name="positions[' + positionIndex + '].amount">';
        document.getElementById("positions").appendChild(positionDiv);
        positionIndex++;
    }
}

const deletePosition = document.getElementsByClassName("deletePosition");
if (deletePosition) {
    Array.from(deletePosition).forEach((button) => {
        button.addEventListener('click', function (e) {
            const positionId = e.target.getAttribute('id');
            fetch("http://localhost:8080/position/delete/" + positionId, {method: "GET"})
                .then(response = () => {
                    response ? alert("Позиция успешно удалена!") : alert("Не удалось удалить позицию!");
                }).catch(error => {
                console.error('There was a problem with your fetch operation:', error);
            })
            const positionDiv = this.parentElement.parentElement;
            positionDiv.remove();
        });
    });
}

const code = document.getElementById("code");
if (code) {
    code.onchange = (e) => {
        const number = e.target.value;
        fetch("http://localhost:8080/document/findByNumber/" + number, {method: "GET"})
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(data => {
                console.log(data);
                if (data) {
                    alert("Такой номер документа уже существует: " + number);
                }
            }).catch(error => {
            console.error('There was a problem with your fetch operation:', error);
        })
    }
}