plot.calculateRegressionLine = function() {

    var data = plot.data;

    x_list = [];
    parse_x(data, function (d) {
        x_list.add(d.x);
    });

    y_list = [];
    parse_y(data, function(d) {
        y_list.add(d.y);
    });

    sigma_x_list = [];
    parse_sigma_x(data, function(d) {
        sigma_x_list.add(d.sigma_x);
    });

    sigma_y_list = [];
    parse_sigma_y(data, function(d) {
        sigma_y_list.add(d.sigma_y);
    });

    rho_list = [];
    parse_rho(data, function(d) {
        rho_list.add(d.rho);
    });

    var regressionLine = topsoil.regression.fitLineToDataFor2D(x_list, y_list, sigma_x_list, sigma_y_list, rho);
    alert(regressionLine);
};
