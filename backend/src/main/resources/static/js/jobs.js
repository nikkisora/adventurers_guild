import html from './utils/html.js'
import JobCard from './components/jobCard.js'
import NewJobModal from './components/newJobModal.js'

export default {
  name: 'App',
  data: () => ({
    jobs: []
  }),
  created() {
    this.fetchData()
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
    <div class="container">
      <div class="row">
        <h3>Guild</h3>
      </div>
      <div class="row mt-3">
        <${NewJobModal} />
      </div>
      <div class="row mt-3">
        ${this.jobs.map((job, index) => html`
          <${JobCard} job="${job}"/>
        `)}
      </div>
    </div>
    `;
  }
}

// <pre>${ this.jobs }</pre>