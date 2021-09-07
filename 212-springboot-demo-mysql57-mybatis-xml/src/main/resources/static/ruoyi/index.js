layer.config({
    extend: 'moon/style.css',
    skin: 'layer-ext-moon'
});

$(function() {
    // MetsiMenu
    $('#side-menu').metisMenu();

    //固定菜单栏
    $(function() {
        $('.sidebar-collapse').slimScroll({
            height: '100%',
            railOpacity: 0.9,
            alwaysVisible: false
        });
    });

    // 菜单切换
    $('.navbar-minimalize').click(function() {
        $("body").toggleClass("mini-navbar");
        SmoothlyMenu();
    });

    $('#side-menu>li').click(function() {
        if ($('body').hasClass('mini-navbar')) {
            NavToggle();
        }
    });
    $('#side-menu>li li a').click(function() {
        if ($(window).width() < 769) {
            NavToggle();
        }
    });

    $('.nav-close').click(NavToggle);

    //ios浏览器兼容性处理
    if (/(iPhone|iPad|iPod|iOS)/i.test(navigator.userAgent)) {
        $('#content-main').css('overflow-y', 'auto');
    }

});

$(window).bind("load resize",
function() {
    if ($(this).width() < 769) {
        $('body').addClass('mini-navbar');
        $('.navbar-static-side').fadeIn();
        $(".sidebar-collapse .logo").addClass("hide");
        $(".slimScrollDiv").css({ "overflow":"hidden" })
    }
});

function NavToggle() {
    $('.navbar-minimalize').trigger('click');
}

function SmoothlyMenu() {
    if (!$('body').hasClass('mini-navbar')) {
        $('#side-menu').hide();
        $(".sidebar-collapse .logo").removeClass("hide");
        setTimeout(function() {
            $('#side-menu').fadeIn(500);
        },
        100);
    } else if ($('body').hasClass('fixed-sidebar')) {
        $('#side-menu').hide();
        $(".sidebar-collapse .logo").addClass("hide");
        setTimeout(function() {
            $('#side-menu').fadeIn(500);
        },
        300);
    } else {
        $('#side-menu').removeAttr('style');
    }
}

/**
 * iframe处理
 */
$(function() {
    //通过遍历给菜单项加上data-index属性
    $(".menuItem").each(function(index) {
        if (!$(this).attr('data-index')) {
            $(this).attr('data-index', index);
        }
    });

    $('.menuItem').on('click', function() {
        // 获取标识数据
        var dataUrl = $(this).attr('href'),
            dataIndex = $(this).data('index'),
            menuName = $.trim($(this).text());
        $(".nav ul li, .nav li").removeClass("selected");
        $(this).parent("li").addClass("selected");
        setIframeUrl($(this).attr("href"));
        $('#navLabel').html(menuName);
        if (dataUrl == undefined || $.trim(dataUrl).length == 0) return false;


        var str = '<a href="javascript:;" class="active menuTab" data-id="' + dataUrl + '">' + menuName + ' <i class="fa fa-times-circle"></i></a>';
        $('.menuTab').removeClass('active');

        // 添加选项卡对应的iframe
        var str1 = '<iframe class="RuoYi_iframe" name="iframe' + dataIndex + '" width="100%" height="100%" src="' + dataUrl + '" frameborder="0" data-id="' + dataUrl + '" seamless></iframe>';
        $('.mainContent').find('iframe.RuoYi_iframe').hide().parents('.mainContent').append(str1);

        $.modal.loading("数据加载中，请稍后...");

        $('.mainContent iframe:visible').load(function () {
            $.modal.closeLoading();
        });
        return false;
    });
    
    $('.menuBlank').on('click', function() {
        var dataUrl = $(this).attr('href');
        window.open(dataUrl);
        return false;
    });
    
    // 全屏显示
    $('#fullScreen').on('click', function () {
    	$(document).toggleFullScreen();
    });
    
    // 设置锚点
    function setIframeUrl(href) {
        var nowUrl = window.location.href;
        var newUrl = nowUrl.substring(0, nowUrl.indexOf("#"));
        window.location.href = newUrl + "#" + href;
    }
    
    $(window).keydown(function(event) {
        if (event.keyCode == 27) {
            $('#content-main').removeClass('max');
            $('#ax_close_max').hide();
        }
    });
    
    window.onhashchange = function() {
        var hash = location.hash;
        var url = hash.substring(1, hash.length);
        $('a[href$="' + url + '"]').click();
    };

});