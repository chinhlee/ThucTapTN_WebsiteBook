const ctx1 = document.getElementById('chart-1');

new Chart(ctx1, {
    type: 'line',
    data: {
        labels: ['Tháng 1', 'Tháng 2', 'Tháng 3', 'Tháng 4', 'Tháng 5', 'Tháng 6', 'Tháng 7',
            'Tháng 8','Tháng 9','Tháng 10','Tháng 11','Tháng 12',],
        datasets: [{
            label: 'Doanh thu',
            data: [120, 100, 99, 52, 25, 39, 79, 132, 99, 59, 26, 10],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});

const ctx2 = document.getElementById('chart-2');

new Chart(ctx2, {
    type: 'bar',
    data: {
        labels: ['Chờ xác nhận', 'Xác nhận', 'Hoàn thành', 'Hủy'],
        datasets: [{
            label: 'Đơn hàng',
            data: [50, 120, 130, 5],
            borderWidth: 1
        }]
    },
    options: {
        indexAxis: 'y',
    }
});