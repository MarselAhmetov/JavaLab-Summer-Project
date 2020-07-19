function addField() {
    console.log("create")
    var competencies = document.getElementById("competenciesFields");
    var competenciesButton = document.getElementById("competenciesButton");
    var formGroup = document.createElement("div");
    formGroup.setAttribute("class", "form-group");
    var element = document.createElement("input");
    element.setAttribute("class", "form-control");
    element.setAttribute("type", "text");
    element.setAttribute("list", "competencies");
    element.setAttribute("name", "competence");
    element.setAttribute("placeholder", "Компетенция");
    formGroup.appendChild(element);
    competencies.insertBefore(formGroup, competenciesButton);
}