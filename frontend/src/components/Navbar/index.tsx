import { ReactComponent as GithubIcon } from "../../assets/img/github.svg";

function navbar() {
  return (
    <header>
      <nav>
        <div>
          <h1>DSMovie</h1>
          <a href="https://github.com/cernandes">
            <div>
              <GithubIcon />
              <p> /cernandes</p>
            </div>
          </a>
        </div>
      </nav>
    </header>
  );
}

export default navbar;
