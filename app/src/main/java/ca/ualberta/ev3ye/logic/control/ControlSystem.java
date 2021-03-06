package ca.ualberta.ev3ye.logic.control;

import ca.ualberta.ev3ye.auxiliary.Helper;

/**
 * Created by Yuey on 2015-03-25.
 * <p/>
 * A state machine designed to facilitate controlling the EV3 in many different ways.
 */
public class ControlSystem
{
	protected static final ControlHandler DEFAULT_CONTROL_PROVIDER = null;
	protected              ControlHandler controlState             = null;

	public ControlSystem()
	{
		this( DEFAULT_CONTROL_PROVIDER );
	}

	public ControlSystem( ControlHandler provider )
	{
		setControlState( provider );
	}

	public void setControlState( ControlHandler newState )
	{
		String oldName = ( controlState != null ) ? controlState.getName() : "null";
		String newName = ( newState != null ) ? newState.getName() : "null";
		Helper.LogV( "CTRL", "Control state switching from " + oldName + " to " + newName );

		this.controlState.cleanup();
		this.controlState = newState;
	}
}
