import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-button/vaadin-button.js';

/**
 * `ex-add-content`
 *
 * Component which includes a button to add more content to the page for
 * demonstration purposes e.g. for testing how the layout behaves with more
 * content or for more easily making the page scrollable if there is otherwise
 * not enough content.
 *
 * @customElement
 * @polymer
 */
class ExAddContent extends PolymerElement {

    static get template() {
        return html`
            <vaadin-button on-click="addContent">Add Content</vaadin-button>
            <slot></slot>
        `;
    }

    static get is() {
        return 'ex-add-content';
    }

    addContent() {
        this.__contentTemplate = this.__contentTemplate || html`
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi
            luctus diam ac posuere pulvinar. Integer ultrices eros quis nisi
            pharetra, eget placerat nibh rutrum. Donec magna nisi, sollicitudin
            non tortor condimentum, aliquet rutrum risus. Interdum et malesuada
            fames ac ante ipsum primis in faucibus. Sed consectetur mauris vel
            mauris semper vulputate. Integer viverra ipsum arcu, in vehicula
            arcu consectetur ac. Cras at augue et nisl egestas rhoncus sit amet
            quis neque. Donec ullamcorper, dui in euismod luctus, massa justo
            interdum risus, et luctus lacus sapien at nisi. Mauris non odio
            mattis, tempor ante eu, scelerisque neque. Quisque ut lectus
            finibus, egestas purus quis, sagittis nunc.</p>
        `;
        this.appendChild(document.importNode(this.__contentTemplate.content, true));
    }
}

customElements.define(ExAddContent.is, ExAddContent);
