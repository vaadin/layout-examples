import { unsafeCSS } from "lit";
import { html, LitElement, css } from "lit";

/**
 * `centered-content-view`
 *
 * CenteredContentView element.
 *
 * @customElement
 * @polymer
 */
class CenteredContentView extends LitElement {
  static get styles() {
    const includedStyles = {};
    includedStyles["common-styles"] =
      document.querySelector("dom-module[id='common-styles']")
        ?.firstElementChild?.content?.firstElementChild?.innerText ?? "";
    return [
      unsafeCSS(includedStyles["common-styles"]),
      css`
        :host {
          display: block;
        }

        .wrapper {
          margin: 0 auto;
          max-width: 960px;
          padding: 0 var(--lumo-space-l);
          background: var(--lumo-base-color)
            linear-gradient(
              hsla(349, 100%, 60%, 0.2),
              hsla(349, 100%, 60%, 0.2)
            );
        }
      `,
    ];
  }
  render() {
    return html`
      <div class="wrapper">
        <div id="main"></div>
      </div>
      <vaadin-button
        style="margin-left: 40%;"
        onclick="window.location.href='https://github.com/vaadin/layout-examples/blob/master/src/main/java/com/vaadin/demo/views/CenteredContentView.java'"
      >
        <img src="icons/Github.png" slot="prefix" />
        View source code
      </vaadin-button>
    `;
  }

  static get is() {
    return "centered-content-view";
  }
}

customElements.define(CenteredContentView.is, CenteredContentView);
