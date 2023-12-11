new Vue({
    el: '#app',
    data: {
        customsData: [],
        newCustomsRecord: {
            customsField1: '',
            customsField2: ''
        },
        mounted() {
            this.fetchCustomsData();
        },
        methods: {
            // ... (предыдущие методы)
            addCustomsRecord() {
                fetch('/api/customs-records', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(this.newCustomsRecord)
                })
                    .then(response => response.json())
                    .then(data => {
                        this.customsData.push(data);
                        this.newCustomsRecord = {}; // Очистим форму
                        this.fetchCustomsData(); // Обновим данные после добавления
                    })
                    .catch(error => console.error('Error:', error));
            }
        }
    },
    methods: {
        fetchCustomsData() {
            fetch('/api/customs-records')
                .then(response => response.json())
                .then(data => {
                    this.customsData = data;
                })
                .catch(error => console.error('Error:', error));
        }
    },
    methods: {
        fetchCustomsDataById(id) {
            fetch(`/api/customs/${id}`)
                .then(response => response.json())
                .then(data => {
                    alert(`Поле: ${data.fieldName}, Значение: ${data.fieldValue}`);
                })
                .catch(error => console.error('Error:', error));
        }
    },
    template: `
        <div> <h2>Таможенные данные</h2>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Поле 1</th>
                <th>Поле 2</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="item in customsData" :key="item.id">
            <tr v-for="item in customsData" :key="item.id" @click="fetchCustomsDataById(item.id)">
                <td>{{ item.id }}</td>
                <td>{{ item.customsField1 }}</td>
                <td>{{ item.customsField2 }}</td>
            </tr>
        </tbody>
    </table>
        </div>
    `
});
