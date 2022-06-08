
import html from '../utils/html.js'

export default {
    name: "NavBar",
    render(){return html`
        <nav class="navbar sticky-top navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">Adventure Guild</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="navbar-nav  ml-auto">
                <a class="nav-link active" href="/">Home <span class="sr-only">(current)</span></a>
                <a class="nav-link active" href="/profile">Profile</a>

            </div>
        </nav>
    `}
}


