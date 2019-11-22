const toggleThemeKeyUpHandler = e => {
    if (e.key === 't') {
        window.utils.toggleTheme();
    }
};

window.utils = window.utils || {
    toggleTheme: () => {
        const currentTheme = document.documentElement.getAttribute('theme') || document.body.getAttribute('theme');
        const newTheme = currentTheme === 'dark' ? 'light' : 'dark';
        // Set theme on <html> instead of <body> to get background color on full
        // height of page when html/body height is automatic.
        document.documentElement.setAttribute('theme', newTheme);
        document.body.removeAttribute('theme');
    },

    activateToggleThemeGlobalShortcut: () => {
        document.addEventListener('keyup', toggleThemeKeyUpHandler, false);
    }
};

window.utils.activateToggleThemeGlobalShortcut();
