#!/usr/bin/env python2
# -*- coding: utf-8 -*-
##################################################
# GNU Radio Python Flow Graph
# Title: Top Block
# Generated: Wed Jul 15 18:37:08 2020
##################################################

if __name__ == '__main__':
    import ctypes
    import sys
    if sys.platform.startswith('linux'):
        try:
            x11 = ctypes.cdll.LoadLibrary('libX11.so')
            x11.XInitThreads()
        except:
            print "Warning: failed to XInitThreads()"

from gnuradio import analog
from gnuradio import audio
from gnuradio import blocks
from gnuradio import eng_notation
from gnuradio import filter
from gnuradio import gr
from gnuradio import wxgui
from gnuradio.eng_option import eng_option
from gnuradio.filter import firdes
from gnuradio.wxgui import forms
from gnuradio.wxgui import scopesink2
from grc_gnuradio import wxgui as grc_wxgui
from optparse import OptionParser
import osmosdr
import time
import wx


class top_block(grc_wxgui.top_block_gui):

    def __init__(self):
        grc_wxgui.top_block_gui.__init__(self, title="Top Block")
        _icon_path = "D:\Programme\GnuRadio\share\icons\hicolor\scalable/apps\gnuradio-grc.png"
        self.SetIcon(wx.Icon(_icon_path, wx.BITMAP_TYPE_ANY))

        ##################################################
        # Variables
        ##################################################
        self.samp_rate = samp_rate = 2000000
        self.low_threshold_slider = low_threshold_slider = 6.15
        self.high_threshold_slider = high_threshold_slider = 6.2
        self.down_rate = down_rate = 250000

        ##################################################
        # Blocks
        ##################################################
        _low_threshold_slider_sizer = wx.BoxSizer(wx.VERTICAL)
        self._low_threshold_slider_text_box = forms.text_box(
        	parent=self.GetWin(),
        	sizer=_low_threshold_slider_sizer,
        	value=self.low_threshold_slider,
        	callback=self.set_low_threshold_slider,
        	label='Low Threshold',
        	converter=forms.float_converter(),
        	proportion=0,
        )
        self._low_threshold_slider_slider = forms.slider(
        	parent=self.GetWin(),
        	sizer=_low_threshold_slider_sizer,
        	value=self.low_threshold_slider,
        	callback=self.set_low_threshold_slider,
        	minimum=0,
        	maximum=150,
        	num_steps=600,
        	style=wx.SL_HORIZONTAL,
        	cast=float,
        	proportion=1,
        )
        self.Add(_low_threshold_slider_sizer)
        _high_threshold_slider_sizer = wx.BoxSizer(wx.VERTICAL)
        self._high_threshold_slider_text_box = forms.text_box(
        	parent=self.GetWin(),
        	sizer=_high_threshold_slider_sizer,
        	value=self.high_threshold_slider,
        	callback=self.set_high_threshold_slider,
        	label='High Threshold',
        	converter=forms.float_converter(),
        	proportion=0,
        )
        self._high_threshold_slider_slider = forms.slider(
        	parent=self.GetWin(),
        	sizer=_high_threshold_slider_sizer,
        	value=self.high_threshold_slider,
        	callback=self.set_high_threshold_slider,
        	minimum=0,
        	maximum=15,
        	num_steps=600,
        	style=wx.SL_HORIZONTAL,
        	cast=float,
        	proportion=1,
        )
        self.Add(_high_threshold_slider_sizer)
        self.threshold_and_signal = scopesink2.scope_sink_f(
        	self.GetWin(),
        	title='Scope Plot',
        	sample_rate=4,
        	v_scale=2,
        	v_offset=0,
        	t_scale=0,
        	ac_couple=False,
        	xy_mode=False,
        	num_inputs=4,
        	trig_mode=wxgui.TRIG_MODE_AUTO,
        	y_axis_label='Counts',
        	size=(1000, 700),
        )
        self.Add(self.threshold_and_signal.win)
        self.threshold = scopesink2.scope_sink_f(
        	self.GetWin(),
        	title='Scope Plot',
        	sample_rate=4,
        	v_scale=0,
        	v_offset=0,
        	t_scale=0,
        	ac_couple=False,
        	xy_mode=False,
        	num_inputs=1,
        	trig_mode=wxgui.TRIG_MODE_AUTO,
        	y_axis_label='Counts',
        )
        self.Add(self.threshold.win)
        self.rational_resampler_xxx_0_0 = filter.rational_resampler_fff(
                interpolation=4,
                decimation=250,
                taps=None,
                fractional_bw=None,
        )
        self.rational_resampler_xxx_0 = filter.rational_resampler_fff(
                interpolation=24,
                decimation=250,
                taps=None,
                fractional_bw=None,
        )
        self.osmosdr_source_0 = osmosdr.source( args="numchan=" + str(1) + " " + 'RTL2838UHIDIR' )
        self.osmosdr_source_0.set_sample_rate(samp_rate)
        self.osmosdr_source_0.set_center_freq(446.7e6, 0)
        self.osmosdr_source_0.set_freq_corr(0, 0)
        self.osmosdr_source_0.set_dc_offset_mode(2, 0)
        self.osmosdr_source_0.set_iq_balance_mode(2, 0)
        self.osmosdr_source_0.set_gain_mode(False, 0)
        self.osmosdr_source_0.set_gain(15, 0)
        self.osmosdr_source_0.set_if_gain(20, 0)
        self.osmosdr_source_0.set_bb_gain(20, 0)
        self.osmosdr_source_0.set_antenna('', 0)
        self.osmosdr_source_0.set_bandwidth(0, 0)

        self.min_threshold_source = analog.sig_source_f(0, analog.GR_CONST_WAVE, 0, 0, high_threshold_slider)
        self.max_threshold_source = analog.sig_source_f(0, analog.GR_CONST_WAVE, 0, 0, low_threshold_slider)
        self.low_pass_filter_0 = filter.fir_filter_ccf(int(samp_rate/down_rate), firdes.low_pass(
        	2, samp_rate, 300e3, 10e3, firdes.WIN_HAMMING, 6.76))
        self.blocks_threshold_ff_0 = blocks.threshold_ff(low_threshold_slider, high_threshold_slider, 0)
        self.blocks_multiply_const_vxx_0 = blocks.multiply_const_vff((5, ))
        self.blocks_file_sink_0 = blocks.file_sink(gr.sizeof_float*1, '../Files/output', False)
        self.blocks_file_sink_0.set_unbuffered(False)
        self.audio_sink_0 = audio.sink(24000, '', True)
        self.analog_wfm_rcv_0 = analog.wfm_rcv(
        	quad_rate=down_rate,
        	audio_decimation=1,
        )

        ##################################################
        # Connections
        ##################################################
        self.connect((self.analog_wfm_rcv_0, 0), (self.rational_resampler_xxx_0, 0))
        self.connect((self.analog_wfm_rcv_0, 0), (self.rational_resampler_xxx_0_0, 0))
        self.connect((self.blocks_multiply_const_vxx_0, 0), (self.blocks_threshold_ff_0, 0))
        self.connect((self.blocks_multiply_const_vxx_0, 0), (self.threshold_and_signal, 1))
        self.connect((self.blocks_threshold_ff_0, 0), (self.blocks_file_sink_0, 0))
        self.connect((self.blocks_threshold_ff_0, 0), (self.threshold, 0))
        self.connect((self.blocks_threshold_ff_0, 0), (self.threshold_and_signal, 0))
        self.connect((self.low_pass_filter_0, 0), (self.analog_wfm_rcv_0, 0))
        self.connect((self.max_threshold_source, 0), (self.threshold_and_signal, 3))
        self.connect((self.min_threshold_source, 0), (self.threshold_and_signal, 2))
        self.connect((self.osmosdr_source_0, 0), (self.low_pass_filter_0, 0))
        self.connect((self.rational_resampler_xxx_0, 0), (self.audio_sink_0, 0))
        self.connect((self.rational_resampler_xxx_0_0, 0), (self.blocks_multiply_const_vxx_0, 0))

    def get_samp_rate(self):
        return self.samp_rate

    def set_samp_rate(self, samp_rate):
        self.samp_rate = samp_rate
        self.osmosdr_source_0.set_sample_rate(self.samp_rate)
        self.low_pass_filter_0.set_taps(firdes.low_pass(2, self.samp_rate, 300e3, 10e3, firdes.WIN_HAMMING, 6.76))

    def get_low_threshold_slider(self):
        return self.low_threshold_slider

    def set_low_threshold_slider(self, low_threshold_slider):
        self.low_threshold_slider = low_threshold_slider
        self._low_threshold_slider_slider.set_value(self.low_threshold_slider)
        self._low_threshold_slider_text_box.set_value(self.low_threshold_slider)
        self.max_threshold_source.set_offset(self.low_threshold_slider)
        self.blocks_threshold_ff_0.set_lo(self.low_threshold_slider)

    def get_high_threshold_slider(self):
        return self.high_threshold_slider

    def set_high_threshold_slider(self, high_threshold_slider):
        self.high_threshold_slider = high_threshold_slider
        self._high_threshold_slider_slider.set_value(self.high_threshold_slider)
        self._high_threshold_slider_text_box.set_value(self.high_threshold_slider)
        self.min_threshold_source.set_offset(self.high_threshold_slider)
        self.blocks_threshold_ff_0.set_hi(self.high_threshold_slider)

    def get_down_rate(self):
        return self.down_rate

    def set_down_rate(self, down_rate):
        self.down_rate = down_rate


def main(top_block_cls=top_block, options=None):

    tb = top_block_cls()
    tb.Start(True)
    tb.Wait()


if __name__ == '__main__':
    main()
