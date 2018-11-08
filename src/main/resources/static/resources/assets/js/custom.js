jQuery.noConflict()(function($) {
    "use strict";
    $('.oi_page_holder').css('visibility', 'hiden');
    // makes sure the whole site is loaded
    jQuery("#status").css('display', 'block');
    jQuery("#preloader").css('display', 'block');
    $(window).load(function() {
        $('.oi_page_holder').css('visibility', 'visible');
        // will first fade out the loading animation
        jQuery("#status").fadeOut("slow");
        // will fade out the whole DIV that covers the website.
        jQuery("#preloader").fadeOut("slow");
        if ($('body').width() > 800) {
            $('.oi_center_header_menu_holder_left').css('margin-top', ($('.oi_logo').height() - $('.oi_center_header_menu_holder_left').height()) / 2);
            $('.oi_center_header_menu_holder_right').css('margin-top', ($('.oi_logo').height() - $('.oi_center_header_menu_holder_right').height()) / 2)

            /*Footer Widgets*/
            $.fn.equalizeHeights = function() {
                return this.height(Math.max.apply(this, $(this).map(function(i, e) {
                    return $(e).height()
                }).get()))
            }
            $.fn.equalizeW = function() {
                return this.width(Math.max.apply(this, $(this).map(function(i, e) {
                    return $(e).width()
                }).get()))
            }
            $('.oi_footer_widget').equalizeHeights();
        }
    });

    $(window).resize(function() {
        if ($('body').width() > 800) {
            $('.oi_center_header_menu_holder_left').css('margin-top', ($('.oi_logo').height() - $('.oi_center_header_menu_holder_left').height()) / 2);
            $('.oi_center_header_menu_holder_right').css('margin-top', ($('.oi_logo').height() - $('.oi_center_header_menu_holder_right').height()) / 2)
        }

    });



    /*$("#ajax-contact-form").submit(function() {
        // this points to our form
        var str = $(this).serialize(); // Serialize the data for the POST-request
        var result = '';
        $.ajax({

            type: "POST",
            url: 'contact.php',
            data: str,
            success: function(msg) {
                if (msg == 'OK') {
                    result = '<div class="alert alert-info">Message was sent to website administrator, thank you!</div>';
                    $("#fields").hide();
                } else {
                    result = msg;
                }
                $("#note").html(result);

            }
        });
        return false;
    });*/


    $("#featured_slider").owlCarousel({
        autoPlay: 3000, //Set AutoPlay to 3 seconds
        loop: true,
        navigation: false,
        scrollPerPage: false,
        pagination: false,
        paginationNumbers: true,
        lazyLoad: false,
        autoplay: true,
        stopOnHover: true,
        smartSpeed: 1000,
        autoplayTimeout: 3000,
        autoplayHoverPause: true,
        responsive: {
            0: {
                margin: 0,
                items: 1
            },
            600: {
                margin: 0,
                items: 2
            },
            800: {
                margin: 0,
                items: 2
            },
            1200: {
                margin: 0,
                items: 3
            },
            1400: {
                margin: 0,
                items: 4
            }
        }

    });
    jQuery.fn.spectragram.accessData = {
        accessToken: '1413693287.7d50a77.c4f0866b4d234d60adc450e6e55972bd',
        clientID: '7d50a770b8b44289af0d313c0be75577'
    };
    //Call spectagram function on the container element and pass it your query
    $('.oi-instagram-2041762505').spectragram('getUserFeed', {
        query: 'insideenvato', //this gets user photo feed
        size: 'big',
        max: 9
    });

    $(".oi_gallery-slider").owlCarousel({
        autoPlay: 3000, //Set AutoPlay to 3 seconds
        loop: true,
        navigation: true,
        navigationText: ["prev", "next"],
        rewindNav: true,
        scrollPerPage: false,
        pagination: true,
        paginationNumbers: true,
        lazyLoad: false,
        autoplay: true,
        stopOnHover: true,
        smartSpeed: 1000,
        autoplayTimeout: 3000,
        autoplayHoverPause: true,
        responsive: {
            0: {
                margin: 0,
                items: 1
            },
            600: {
                margin: 0,
                items: 1
            },
            800: {
                margin: 0,
                items: 1
            },
            1200: {
                margin: 0,
                items: 1
            }
        }

    });

    /*Responsive*/
    $("#oi_top_line_show_menu", ".oi_container_holder_revex").on("click", function(e) {
        $(this).toggleClass('oi_active_button');
        $('.oi_topline_menu').toggleClass('oi_active_top_menu');
		return false;
    });
    $("#oi_top_line_show_soc_icons", ".oi_container_holder_revex").on("click", function(e) {
        $(this).toggleClass('oi_active_button');
        $('.oi_soc_icons').toggleClass('oi_active_top_soc');
		return false;
    });
    $("#oi_main_show_menu", ".oi_standard_header_holder_holder").on("click", function(e) {
        $(this).toggleClass('oi_active_button');
        $('.oi_menu_all').toggleClass('oi_active_all_menu');
		return false;
    });

});