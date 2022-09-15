const date_picker_element = document.querySelector('.date-picker');
const selected_date_element = document.querySelector('.date-picker .selected-date');
const dates_element = document.querySelector('.date-picker .dates');
const mth_element = document.querySelector('.date-picker .dates .month .mth');
const next_mth_element = document.querySelector('.date-picker .dates .month .next-mth');
const prev_mth_element = document.querySelector('.date-picker .dates .month .prev-mth');
const days_element = document.querySelector('.date-picker .dates .days');
const rent_button = document.querySelector('.rent-button');
const months = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];

// const createSelectedDateObj = (selectedDay, selectedMonth, selectedYear) => ({ selectedDay, selectedMonth, selectedYear });

let date = new Date();
let day = date.getDate();
let month = date.getMonth();
let year = date.getFullYear();
let todayDate = new Date(year, month, day, (0, 0, 0, 0));


let selectedDate = date;
let selectedDay = day;
let selectedMonth = month;
let selectedYear = year;
let selectedDates = [];

let counter = 0;


//TEST DATA HARCODED
let disableDates = [new Date(year, month, 18, (0, 0, 0, 0)), new Date(year, month, 19, (0, 0, 0, 0)), new Date(year, month, 20, (0, 0, 0, 0))];

selected_date_element.textContent = formatDate(date);
selected_date_element.dataset.value = selectedDate;
mth_element.textContent = months[month] + ' ' + year;


populateDates();

// EVENT LISTENERS
date_picker_element.addEventListener('click', toggleDatePicker);
next_mth_element.addEventListener('click', goToNextMonth);
prev_mth_element.addEventListener('click', goToPrevMonth);
rent_button.addEventListener('click', ajaxPost);


document.addEventListener('click', function handleClickOutsideBox(event) {
	console.log(event.composedPath().includes(date_picker_element));
	//console.log(date_picker_element.contains(event.target));
	if (!event.composedPath().includes(date_picker_element)) {
		purgeSelectedDates();
		populateDates();
	}
});


// FUNCTIONS
function ajaxPost() {
	console.log(selectedDates[0]);
	console.log(selectedDates[1]);

	// PREPARE Rent DATA
	var rentData = {
		startRentDate: selectedDates[0],
		endRentDate: selectedDates.length > 1 ? selectedDates[1] : selectedDates[0],
		lotId: lotId
	}

	// DO POST
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/api/rent",
		data: JSON.stringify(rentData),
		dataType: 'json',
		success: function (result) {
			if (result.status == "success") {
				console.log("succes");
			} else {
				console.log("fail");
			}
			console.log(result);
		},
		error: function (e) {
			alert("Error!")
			console.log("ERROR: ", e);
		}
	});

}

function toggleDatePicker(e) {
	if (!checkEventPathForClass(e.path, 'dates')) {
		dates_element.classList.toggle('active');
	}
}

function goToNextMonth(e) {
	month++;
	if (month > 11) {
		month = 0;
		year++;
	}
	mth_element.textContent = months[month] + ' ' + year;
	populateDates();
}

function goToPrevMonth(e) {
	month--;
	if (month < 0) {
		month = 11;
		year--;
	}
	mth_element.textContent = months[month] + ' ' + year;
	populateDates();
}

function checkInRange(d) {
	let sortedDates = selectedDates.sort((date1, date2) => date1 - date2);
	let start = sortedDates[0];
	let end = sortedDates[1];
	let dates = [];
	let date = new Date(start.getTime());

	while (date < end) {
		dates.push(new Date(date).toDateString());
		date.setDate(date.getDate() + 1);
	}
	dates[0] = '';
	//console.log(dates.map(d => checkNotDisabled(d)));

	//console.log(!dates.map(d => checkNotDisabled(d)).includes(false));
	if (!dates.map(d => checkNotDisabled(d)).includes(false)) {
		return dates.includes(d.toDateString())
	} else {
		purgeSelectedDates();
	}
}


function checkNotDisabled(d) {
	return disableDates.length == 0 ? true : !disableDates.map(date => date.toDateString()).includes(d);
}

function purgeSelectedDates() {
	selectedDates = [];
	counter = 0;
	rent_button.classList.remove('active');
}


function populateDates() {
	days_element.innerHTML = '';
	let amount_days = getDaysInMonth(year, month);

	for (let i = 0; i < amount_days; i++) {
		const day_element = document.createElement('div');
		day_element.classList.add('day');
		day_element.textContent = i + 1;
		let setDate = new Date(year, month, (i + 1), (0, 0, 0, 0));

		if (counter > 1 && (checkInRange(setDate))) {
			day_element.classList.add('selected-between');
		}

		for (let k = 0; k < selectedDates.length; k++) {
			if (selectedDates[k].toDateString() == setDate.toDateString()) {
				day_element.classList.add('selected');
			}
		}

		// if element == selected

		// if ((i + 1) == selectedDay &&  year == selectedYear && month == selectedMonth ) {
		// 	day_element.classList.add('selected');
		// }
		if (checkNotDisabled(setDate.toDateString())) {
			day_element.addEventListener('click', function () {
				if (counter >= 2) {
					purgeSelectedDates();
				}

				selectedDate = new Date(year + '-' + (month + 1) + '-' + (i + 1));
				selectedDates.push(new Date(year, month, (i + 1), (0, 0, 0, 0)));
				rent_button.classList.add('active');
				counter++;
				// selectedDay = (i + 1);
				// selectedMonth = month;
				// selectedYear = year;

				selected_date_element.textContent = formatDate(selectedDate);
				selected_date_element.dataset.value = selectedDate;
				populateDates();
			});
		} else {
			day_element.classList.add('disabled');
		}


		days_element.appendChild(day_element);
	}
}

// HELPER FUNCTIONS
function getDaysInMonth(year, month) {
	return new Date(year, month + 1, 0).getDate();
}

function checkEventPathForClass(path, selector) {
	for (let i = 0; i < path.length; i++) {
		if (path[i].classList && path[i].classList.contains(selector)) {
			return true;
		}
	}

	return false;
}

function formatDate(d) {
	let day = d.getDate();
	if (day < 10) {
		day = '0' + day;
	}

	let month = d.getMonth() + 1;
	if (month < 10) {
		month = '0' + month;
	}

	let year = d.getFullYear();

	return day + ' / ' + month + ' / ' + year;
}

