

import html from './utils/html.js'

export default {
  name: 'App',
  data: () => ({
    jobs: "null"
  }),
  created() {
    this.fetchData()
  },
  methods:{
    async fetchData(){
      const jobs_json = await(await fetch('/jobs')).json()
      this.jobs = JSON.stringify(jobs_json.data, null, '\t')
    },
    formatDate(v) {
      return v.replace(/T|Z/g, ' ')
    }
  },
  render(){
    return html`
      <div>
        jobs are <pre>${ this.jobs }</pre>
      </div>
    `;
  }
}