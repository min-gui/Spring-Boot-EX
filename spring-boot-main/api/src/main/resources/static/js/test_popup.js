// 팝업 창을 열고 AJAX 요청을 보내는 함수
function openPopUp() {
    // 팝업 창 생성
    let popup = window.open("", "Popup", "width=400,height=400,location=no,status=no");
    popup.document.write("<h1>Data Loading</h1>");  // 팝업 창 내용

    // AJAX 요청으로 데이터 가져오기
    // fetch('/api/data')
    //     .then(response => response.json())
    //     .then(data => {
    //         // 데이터를 팝업 창에 표시
    //         popup.document.body.innerHTML = "<h1>Data from DB</h1>";
    //         let list = "<ul>";
    //         data.forEach(item => {
    //             list += `<li>${item}</li>`;
    //         });
    //         list += "</ul>";
    //         popup.document.body.innerHTML += list;
    //     })
    //     .catch(error => {
    //         console.error('Error fetching data:', error);
    //         popup.document.body.innerHTML = "<h1>Error loading data</h1>";
    //     });
}

function openImagePopup() {
    let popup = window.open("", "Image Popup", "width=800,height=600");
    popup.document.write(`
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Image Upload and Reorder</title>
            <style>
                ul { list-style-type: none; padding: 0; }
                li { padding: 8px; margin-bottom: 4px; background-color: #f1f1f1; cursor: move; }
            </style>
        </head>
        <body>
            <h2>Upload and Reorder Images</h2>
            <input type="file" id="fileInput" multiple>
            <button onclick="uploadFiles()">Upload Files</button>
            <h3>Image List</h3>
            <ul id="fileList"></ul>

            <script>
                function uploadFiles() {
                    let fileInput = document.getElementById("fileInput");
                    let fileList = document.getElementById("fileList");
                    fileList.innerHTML = "";

                    for (let i = 0; i < fileInput.files.length; i++) {
                        let file = fileInput.files[i];
                        let li = document.createElement("li");
                        li.textContent = file.name;
                        li.setAttribute("draggable", true);
                        li.addEventListener("dragstart", dragStart);
                        li.addEventListener("dragover", dragOver);
                        li.addEventListener("drop", drop);
                        fileList.appendChild(li);
                    }
                }

                function dragStart(event) {
                    event.dataTransfer.setData("text/plain", event.target.innerText);
                    event.target.style.opacity = "0.4";
                }

                function dragOver(event) {
                    event.preventDefault();
                }

                function drop(event) {
                    event.preventDefault();
                    let draggedData = event.dataTransfer.getData("text");
                    let targetLi = event.target;
                    let draggedLi = Array.from(targetLi.parentElement.children).find(li => li.innerText === draggedData);
                    [targetLi.innerText, draggedLi.innerText] = [draggedLi.innerText, targetLi.innerText];
                }
            </script>
        </body>
        </html>
    `);
}

function openImagePopUpBtnUI() {
    let popup = window.open("", "Image Popup", "width=800,height=600");
    popup.document.write(`
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Image Upload and Reorder with Buttons</title>
            <!-- 외부 CSS 파일 로드 -->
            <link rel="stylesheet" href="/css/styles.css">
        </head>
        <body>
            <h2>Upload and Reorder Images with Buttons</h2>
        
            <!-- 파일 업로드 -->
            <input type="file" id="fileInput" multiple>
            <button onclick="uploadFiles()">Upload Files</button>
        
            <!-- 업로드된 사진 이름 리스트 -->
            <h3>Image List</h3>
            <ul id="fileList"></ul>
        
            <script>
                // 파일 업로드 후 리스트에 추가하는 함수
                function uploadFiles() {
                    let fileInput = document.getElementById("fileInput");
                    let fileList = document.getElementById("fileList");
        
                    // 기존 리스트 초기화
                    fileList.innerHTML = "";
        
                    // 파일들을 리스트로 추가
                    for (let i = 0; i < fileInput.files.length; i++) {
                        let file = fileInput.files[i];
        
                        // li 요소를 만들고 파일명을 추가
                        let li = document.createElement("li");
                        li.textContent = file.name;
        
                        // 버튼 컨테이너 추가
                        let buttonContainer = document.createElement("div");
                        buttonContainer.classList.add("buttons");
        
                        // 위로 이동 버튼
                        let upButton = document.createElement("button");
                        upButton.textContent = "▲";
                        upButton.onclick = function () {
                            moveUp(li);
                        };
        
                        // 아래로 이동 버튼
                        let downButton = document.createElement("button");
                        downButton.textContent = "▼";
                        downButton.onclick = function () {
                            moveDown(li);
                        };
        
                        // 버튼들을 컨테이너에 추가
                        buttonContainer.appendChild(upButton);
                        buttonContainer.appendChild(downButton);
        
                        // li에 버튼 컨테이너 추가
                        li.appendChild(buttonContainer);
        
                        // 리스트에 추가
                        fileList.appendChild(li);
                    }
                }
        
                // 항목을 위로 이동시키는 함수
                function moveUp(item) {
                    let prevItem = item.previousElementSibling;
                    if (prevItem) {
                        item.parentNode.insertBefore(item, prevItem);
                    }
                }
        
                // 항목을 아래로 이동시키는 함수
                function moveDown(item) {
                    let nextItem = item.nextElementSibling;
                    if (nextItem) {
                        item.parentNode.insertBefore(nextItem, item);
                    }
                }
            </script>
        </body>
        </html>
    `);
}