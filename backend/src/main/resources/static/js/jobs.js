import html from './utils/html.js'
import JobCard from './components/jobCard.js'
import NewJobModal from './components/newJobModal.js'
import navBar from './components/navBar.js'

export default {
  name: 'App',
  data: () => ({
    jobs: []
  }),
  created() {
    this.fetchData()
    // console.log(await(await(fetch('/login', type='POST')).json()))
    console.log(document)
    const csrf = document.querySelector('meta[name="csrf-token"]')
    console.log(csrf)
  },
  methods:{
    async fetchData(){
      this.jobs = (await(await fetch('/jobs')).json()).data.jobs
    },
    press(){
      console.log('pressed')
    }
  },
  render(){
    return html`
    <${navBar} />
    <div class="container">
      <div class="row mt-3">
        <div class="col-3">
          <${NewJobModal} />
        </div>
        <div class="col md-auto">
          ${this.jobs.map((job, index) => html`
            <${JobCard} job="${job}"/>
          `)}
        </div>
      </div>
      <div class="row mt-3">

      </div>
    </div>
    `;
  }
}

// <pre>${ this.jobs }</pre>