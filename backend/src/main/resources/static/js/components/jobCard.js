import html from '../utils/html.js'

export default {
    name: "JobCard",
    props: ['job'],
    created(){
        if (this.job.image == null) this.job.image = "../../imgs/no-img.png"
        console.log(this.job)
    },
    methods:{
        formatDate(v) {
            return v.replace(/T|Z/g, ' ')
        }
    },
    render(){
        return html`
            <div class="card mb-3" style="max-width: 700px;">
                <div class="row no-gutters">
                    <div class="col-sm-4">
                        <img src=${this.job.image} alt="No image" class="img-fluid"/>
                    </div>

                    <div class="col-sm-8">
                        <div class="card-body">
                            <h5 class="card-title">${this.job.title}</h5>
                            <p class="card-text">${this.job.description}</p>
                            <p class="card-text"><small class="text-muted">Created: ${this.formatDate(this.job.date_added)}</small></p>
                        </div>
                    </div>
                </div>
            </div>
        `
    }
}