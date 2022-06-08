import html from '../utils/html.js'

export default {
    name: "NewJobModal",
    data: () => ({
        form: {
            title: '',
            location: '',
            description: '',
            reward: 0,
            rank: '',
            image: ''
        }
    }),
    created(){

    },
    methods:{
        sendData() {
            console.log('haosldfhlasdfhj')
            axios.post('/jobs', this.form)
                .then((res) => {
                    console.log(res)
                })
                .catch((error) => {
                    console.log(error)
                })
        },
        convertToBase64(file){
            return new Promise((resolve, reject) => {
                const fileReader = new FileReader();
                fileReader.readAsDataURL(file);

                fileReader.onload = () => {
                    resolve(fileReader.result);
                };

                fileReader.onerror = (error) => {
                    reject(error);
                };
            });
        },
        async uploadImage(event) {
            const file = event.target.files[0];
            const base64 = await this.convertToBase64(file);
            this.form.image = base64
            console.log(base64)
            // document.getElementById("imgUploadText").innerText = base64;
        }
    },
    render(){return html`
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#newJobModal">Add job</button>

        <div class="modal fade" id="newJobModal" tabindex="-1" aria-labelledby="newJobModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                <form id="jobForm" v-on:submit="${()=>{this.sendData()}}">
                    <div class="modal-header">
                        <h5 class="modal-title" id="newJobModalLabel">Add new job</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">x</span>
                        </button>
                    </div>
                    <div class="modal-body">

                            <div class="form-group">
                                <label for="titleInput">Название задания</label>
                                <input onchange=${(e) => {this.form.title = e.target.value}} name="title" type="text" class="form-control" id="titleInput" required placeholder="Название"/>
                            </div>
                            <div class="form-group">
                                <label for="locationInput">Локация</label>
                                <input onchange=${(e) => {this.form.location = e.target.value}} name="location" type="text" class="form-control" id="locationInput" required placeholder="За тридевять земель"/>
                            </div>
                            <div class="form-group">
                                <label for="descriptionInput">Описание</label>
                                <textarea onchange=${(e) => {this.form.description = e.target.value}} name="description" class="form-control" id="descriptionInput" rows="3" required placeholder="Подробное описание задания"></textarea>
                            </div>
                            <div class="form-group">
                                <label for="rewardInput">Награда</label>
                                <input onchange=${(e) => {this.form.reward = e.target.value}} name="reward" type="number" class="form-control" id="rewardInput" required value=0 min=1 placeholder="Размер награды (минимально 1)"/>
                            </div>
                            <div class="form-group">
                                <label for="rankSelect">Выбирите предполагаемый ранг задания</label>
                                <select onchange=${(e) => {this.form.rank = e.target.value}} name="rank" class="form-control" id="rankSelect">
                                    <option>S</option>
                                    <option>A+</option>
                                    <option>A</option>
                                    <option>B</option>
                                    <option>C</option>
                                    <option>D</option>
                                    <option>E</option>
                                    <option>F</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="imgUpload">Фотография для задания</label>
                                <input type="file" class="form-control-file" id="imgUpload" accept="image/png, image/jpeg" onchange="${(e) => {this.uploadImage(e)}}"/>
                                <input type="hidden" name="image" id="imgUploadText"/>
                            </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
                        <button type="button" class="btn btn-primary" onclick="${() => {this.sendData()}}">Создать задание</button>
                    </div>
                    </form>
                </div>
            </div>
        </div>
    `}
}