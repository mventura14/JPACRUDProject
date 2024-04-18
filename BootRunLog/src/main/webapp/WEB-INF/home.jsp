<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Prog Log</title>
    <link rel="stylesheet" type="text/css" href="css/home.css">
</head>

<body>

    <header></header>

    <main>

        <div class="addSearch">
            <div>
                <form class="idSearch" action="getService.do" method="GET">
                    Log entry ID:
                    <input type="text" name="id">
                    <button type="submit">Show Entry</button>
                </form>

                <form class="logForm" action="addLogEntry.do" method="POST">
                    <div>
                        <div>
                            <label>Date</label>
                            <input type="date" maxlength="45" required name="date">
                        </div>

                        <div>
                            <label>Type</label>
                            <input type="text" maxlength="45" required name="type">
                        </div>
                        <div>
                            <label>Time(M)</label>
                            <input type="number" min="0" required name="timeInMinutes">
                        </div>
                        <div>
                            <label>Distance(M)</label>
                            <input type="number" min="0" step="any" required name="distanceInMiles">
                        </div>
                    </div>
                    <div>
                        <div>
                            <label>Description</label>
                            <textarea rows="2" cols="15" name="description" required></textarea>
                        </div>
                        <div>
                            <button type="submit">Submit</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

		<div class="logEntryContainer">

			<c:forEach var="log" items="${runner}">

				<div class="logItem">
                <div class="details">
                    <div>
                        <div>
                            <div>
                                <p>Date</p>
                                <p>${log.date}</p>
                            </div>

                            <div>
                                <p>Type</p>
                                <p>${log.type}</p>
                            </div>
                            <div>
                                <p>Time (min)</p>
                                <p>${log.timeInMinutes}</p>
                            </div>
                            <div>
                                <p>Distance (m)</p>
                                <p>${log.distanceInMiles}</p>
                            </div>

                        </div>
                        <div>
                            <p>Description</p>
                            <p>${log.description}</p>
                        </div>
                    </div>
                    <div>
                        <label class="editBtn" for="selection${log.id}">Edit</label>
                    </div>
                </div>

                <div class="editFormDisp">
                    <input type="radio" name="editSelection" id="selection${log.id}">
                    <div>
                        <form class="logForm" action="updateEntry" method="POST">

                            <input class="id" type="hidden" readonly name="id" value="${log.id}">
                            <p>ID: ${log.id}</p>

                            <div>
                                <div>
                                    <label>Date</label>
                                    <input type="date" maxlength="45" required name="date" value="${log.date }">
                                </div>

                                <div>
                                    <label>Type</label>
                                    <input type="text" maxlength="45" required name="type" value="${log.type}">
                                </div>

                                <div>
                                    <label>Time(M)</label>
                                    <input type="number" min="0" required name="timeInMinutes" value="${log.timeInMinutes}">
                                </div>

                                <div>
                                    <label>Distance(M)</label>
                                    <input type="number" min="0" step="any" required name="distanceInMiles"
                                        value="${log.distanceInMiles}">
                                </div>

                            </div>
                            <div>
                                <div>
                                    <label>Description</label>
                                    <textarea rows="2" cols="15" name="description" required>${log.description}</textarea>
                                </div>
                                <div>
                                    <button type="submit">Submit</button>
                                </div>
                            </div>
                        </form>

                        <form action="deleteEntry" method="POST">
                            <button class="delete-btn" type="submit" name="id" value="${log.id}">Delete</button>
                        </form>
                    </div>
                </div>
            </div>




			</c:forEach>


		</div>






	</main>
	<footer></footer>







</body>
</html>