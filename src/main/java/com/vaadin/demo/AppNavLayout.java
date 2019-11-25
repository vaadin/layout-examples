package com.vaadin.demo;

import java.util.ArrayList;
import java.util.List;

import org.vaadin.artur.github_corner.GitHubCorner;

import com.vaadin.demo.views.IntroView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.ParentLayout;
import com.vaadin.flow.router.RouterLink;

@ParentLayout(MainView.class)
public class AppNavLayout extends AppLayout implements AfterNavigationObserver {

    private final Tabs menu;

    public AppNavLayout() {
        menu = createMenuTabs();
        addToNavbar(menu);
        addToNavbar(new GitHubCorner("vaadin", "layout-examples"));
    }

    private static Tabs createMenuTabs() {
        final Tabs tabs = new Tabs();
        tabs.setOrientation(Tabs.Orientation.HORIZONTAL);
        tabs.add(getAvailableTabs());
        return tabs;
    }

    private static Tab[] getAvailableTabs() {
        final List<Tab> tabs = new ArrayList<>();
        tabs.add(createTab("Layouts", IntroView.class, VaadinIcon.LAYOUT));
        tabs.add(
                createTab("GitHub", "https://github.com/vaadin/layout-examples",
                        VaadinIcon.EXTERNAL_LINK));
        return tabs.toArray(new Tab[tabs.size()]);
    }

    private static Tab createTab(String title,
            Class<? extends Component> viewClass) {
        return createTab(new RouterLink(title, viewClass));
    }

    private static Tab createTab(String title,
            Class<? extends Component> viewClass, VaadinIcon icon) {
        return createTab(new Icon(icon), new RouterLink(title, viewClass));
    }

    private static Tab createTab(String title, String href, VaadinIcon icon) {
        return createTab(new Icon(icon), new Anchor(href, title));
    }

    private static Tab createTab(Component... content) {
        final Tab tab = new Tab();
        // tab.addThemeVariants(TabVariant.LUMO_ICON_ON_TOP);
        tab.add(content);
        return tab;
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        // Select the matching navigation tab on page load
        String location = event.getLocation().getFirstSegment();
        menu.getChildren().forEach(component -> {
            if (component instanceof Tab) {
                Tab tab = (Tab) component;
                tab.getChildren().findFirst().ifPresent(component1 -> {
                    if (component1 instanceof RouterLink) {
                        RouterLink link = (RouterLink) component1;
                        if (link.getHref().equals(location)) {
                            menu.setSelectedTab(tab);
                        }
                    }
                });
            }
        });
    }
}
