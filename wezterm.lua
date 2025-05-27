-- Pull in the wezterm API
local wezterm = require 'wezterm'

-- This will hold the configuration.
local config = wezterm.config_builder()

-- This is where you actually apply your config choices

-- For example, changing the color scheme:
-- config.color_scheme = 'AdventureTime'
config.font=wezterm.font("MesloLGS Nerd Font Mono")
config.font_size = 19


config.keys = {
  -- This will create a new split and run your default program inside it
  {
    key = ':',
    mods = 'CTRL|SHIFT|ALT',
    action = wezterm.action.SplitHorizontal { domain = 'CurrentPaneDomain' },
  },
  -- This will create a new split and run your default program inside it
  {
    key = '"',
    mods = 'CTRL|SHIFT|ALT',
    action = wezterm.action.SplitVertical { domain = 'CurrentPaneDomain' },
  },
  -- Add a shortcut for closing the current pane
    {
      key = 'w',
      mods = 'CTRL|SHIFT',
      action = wezterm.action.CloseCurrentPane { confirm = true },
    },
}


return config
