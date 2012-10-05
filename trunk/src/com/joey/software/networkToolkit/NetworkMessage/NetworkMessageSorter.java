package com.joey.software.networkToolkit.NetworkMessage;

import java.util.Vector;

public class NetworkMessageSorter
{
	Vector<NetworkMessageDestination> messageDestination = new Vector<NetworkMessageDestination>();

	public NetworkMessageSorter()
	{
	}

	/**
	 * This will sort a message and send it to its destination
	 * 
	 * @param message
	 *            - the message to sort
	 */
	public synchronized void sortMessage(String message)
	{
		for (NetworkMessageDestination dest : messageDestination)
		{
			if (dest.isDestination(message))
			{
				dest.messageRecieved(message);
			}
		}
	}

	/**
	 * This will add another destination to the sorter
	 * 
	 * @param destination
	 */
	public void addDestination(NetworkMessageDestination destination)
	{
		messageDestination.add(destination);
	}

	public void removeDestination(int index)
	{
		messageDestination.remove(index);
	}

	public NetworkMessageDestination getMessageDestination(int index)
	{
		return messageDestination.get(index);
	}

	/**
	 * @return the messageDestination
	 */
	public Vector<NetworkMessageDestination> getMessageDestinations()
	{
		return messageDestination;
	}

}
